package com.example.demo.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void 회원등록(){
        Member member = Member.builder()
                .user_id("애요용")
                .user_pw("1234")
                .user_name("냐냐냐")
                .user_role(false)
                .build();

        repository.save(member);
    }

    @Test
    public void 회원목록조회(){
        List<Member> list =  repository.findAll();
        for(Member member: list){

        }
    }

}
