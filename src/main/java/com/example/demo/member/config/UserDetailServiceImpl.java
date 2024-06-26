package com.example.demo.member.config;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.security.dto.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    MemberService service;

//    사용자 아이디기반, 인증객체생성메소드 (로그인처리, username:사용자아이디)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO dto = service.read(username);

        if (dto == null){
            throw new UsernameNotFoundException("");
        }else {
            return new CustomUser(dto);
        }
    }
}
