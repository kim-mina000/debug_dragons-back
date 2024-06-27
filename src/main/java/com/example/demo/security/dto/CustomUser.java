package com.example.demo.security.dto;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;



public class CustomUser extends User {

  public CustomUser(MemberDTO dto) {
	super(dto.getUserId(), dto.getUserPw(), Arrays.asList(new SimpleGrantedAuthority(dto.getUserRole())));
  }

}

