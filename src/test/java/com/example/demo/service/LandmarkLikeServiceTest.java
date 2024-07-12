package com.example.demo.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.service.LandmarkLikeService;
import com.example.demo.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandmarkLikeServiceTest {

    @Autowired
    LandmarkLikeService service;

    @Test
    public void 좋아요true_취소false(){
        Landmark landmark = Landmark.builder().landmarkNo(1).build();
        Member member = Member.builder().userId("green").build();
        service.toggleLike(landmark,member);

    }
}
