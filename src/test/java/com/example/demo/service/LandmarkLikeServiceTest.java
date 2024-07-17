package com.example.demo.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.Landmark.repository.LandmarkLikeRepository;
import com.example.demo.Landmark.service.LandmarkLikeService;
import com.example.demo.course.entity.CourseLike;
import com.example.demo.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LandmarkLikeServiceTest {

    @Autowired
    LandmarkLikeService service;

    @Test
    public void 좋아요true_취소false(){
        Landmark landmarkDto = Landmark.builder().landmarkNo(1).build();
        Member memberDto = Member.builder().userId("bbq5883").build();
        service.toggleLike(landmarkDto, memberDto);

    }

    @Test
    public void 아이디로좋아요랜드마크게시글검색(){
        Member user = Member.builder().userId("bbq5883").build();
        List<LandmarkLike> list = service.getAllLikesByUser(user);
        for (LandmarkLike like :list){
            System.out.println(like);
        }
    }

    @Test
    public void 좋아요갯수(){
        Landmark landmark = Landmark.builder().landmarkNo(1).build();
        int landmarkNo = landmark.getLandmarkNo();
        int resultLikeCount = service.likeCount(landmarkNo);
        System.out.println("좋아요 갯수: " + resultLikeCount);
    }



}
