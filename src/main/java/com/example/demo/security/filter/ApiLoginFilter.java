package com.example.demo.security.filter;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.security.dto.CustomUser;
import com.example.demo.security.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Objects;

/*
 * 로그인 요청이 들어오면 아이디와 패스워드를 확인하고 jwt토큰을 발급하는 필터
 * */

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter {

    private JWTUtil jwtUtil;

    private MemberService memberService;

    //생성자에서 필요한 멤버서비스 전달받기
    public ApiLoginFilter(String defaultFilterProcessesUrl, JWTUtil jwtUtil, MemberService memberService) {

        super(defaultFilterProcessesUrl);
        this.jwtUtil = jwtUtil;
        this.memberService = memberService;

    }

    // 로그인 요청이 들어오면 아이디와 패스워드를 확인해서 인증하기
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");

		if(id == null) {
			throw new BadCredentialsException("id cannot be null");
		}

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(id, pw);

		return getAuthenticationManager().authenticate(authToken);
	}

	// 인증에 성공했으면 jwt토큰을 발급하고 응답하기
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        log.info("-----------------ApiLoginFilter---------------------");
        log.info("successfulAuthentication: " + authResult);

        log.info(authResult.getPrincipal());

        //email address
        String userId = ((CustomUser)authResult.getPrincipal()).getUsername();

        String token = null;
        try {
            token = jwtUtil.generateToken(userId);  //토큰발급하고

            MemberDTO member =memberService.read(userId);   //userId꺼내고

//         해쉬맵 이용하여 token과 user정보 넘기기. 해쉬맵 안에 담은 후 Json으로 변환 후 넘겨요 !
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", token);    //토큰 바이트로 변환하지 마시고, 문자열 그대로
            data.put("user", member);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

//            객체 -> json변환 : 백 ~ 프론트간에는 JSON으로 변환해줘야 주고받고 가능
            ObjectMapper objectMapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HHLmm:ss"));
            PrintWriter out = response.getWriter();
            out.print(objectMapper.writeValueAsString(data));

            log.info(token);
            log.info(data);

         // JWT 토큰 생성 및 응답 헤더에 추가

            response.setHeader("Authorization", "Bearer " + token);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





