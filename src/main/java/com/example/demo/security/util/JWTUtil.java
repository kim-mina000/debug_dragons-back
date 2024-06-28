package com.example.demo.security.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;
import lombok.extern.log4j.Log4j2;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// JWT 생성, 유효성 검증

@Log4j2
public class JWTUtil {

    private String secretKey = "zerock12345678";

    //1month
    private long expire = 60 * 24* 1;

    //로그아웃된 토큰 리스트
    private Set<String> blacklist = new HashSet<>();

    //로그아웃시 블랙 리스트에 추가
    public void invalidateToken(String token) {
        blacklist.add(token);
    }

    // 블랙 리스트에 포함되어 있는지 확인
    public boolean isTokenInvalid(String token) {
        return blacklist.contains(token);
    }


    public String generateToken(String content) throws Exception{

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expire).toInstant()))
                .claim("sub", content)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes("UTF-8"))
                .compact();
    }

    public String validateAndExtract(String tokenStr)throws Exception {

        String contentValue = null;

        try {
            DefaultJws defaultJws = (DefaultJws) Jwts.parser()
                    .setSigningKey(secretKey.getBytes("UTF-8")).parseClaimsJws(tokenStr);

            log.info(defaultJws);

            log.info(defaultJws.getBody().getClass());

            DefaultClaims claims = (DefaultClaims) defaultJws.getBody();

            log.info("------------------------");

            contentValue = claims.getSubject();



        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            contentValue = null;
        }
        return contentValue;
    }

}
