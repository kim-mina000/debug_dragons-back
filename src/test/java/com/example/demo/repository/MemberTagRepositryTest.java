package com.example.demo.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberTag;
import com.example.demo.member.repository.MemberTagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberTagRepositryTest {

    @Autowired
    MemberTagRepository repository;

    @Test
    public void 멤버태그추가(){
        MemberTag tag = MemberTag.builder().memberTag("1").userId(Member.builder().userId("11").build()).build();
        repository.save(tag);

    }


}
