package com.example.demo.member.service;

import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;




}
