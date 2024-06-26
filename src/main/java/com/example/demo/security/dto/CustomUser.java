package com.example.demo.security.dto;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;



public class CustomUser extends User {

  public CustomUser(MemberDTO dto) {
	super(dto.getUser_id(), dto.getUser_pw(), Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
  }
  
}

