package com.example.demo.Landmark.service;


import com.example.demo.Landmark.dto.LandmarkLikeDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface LandmarkLikeService {

    void toggleLike(Landmark landmark, Member userId);

    List<LandmarkLike> getAllLikesByUser(Member userId);

    int likeCount(int landmark);

    LandmarkLike getUserLikeStatus(Member userId, boolean isLike);

    default LandmarkLikeDTO entityToDto (LandmarkLike entity){

        Member member = entity.getUserId();

        LandmarkLikeDTO dto = LandmarkLikeDTO.builder()
                .landmarkLikeNo(entity.getLandmarkLikeNo())
                .landmarkNo(entity.getLandmarkLikeNo())
                .userId(member.toString())
                .isLike(entity.isLike())
                .build();

        return dto;
    }

    default LandmarkLike dtoToEntity(LandmarkLikeDTO dto){

        Landmark landmarkNo = Landmark.builder().landmarkNo(dto.getLandmarkNo()).build();
        Member userId = Member.builder().userId(dto.getUserId()).build();

        LandmarkLike entity = LandmarkLike.builder()
                .landmarkLikeNo(dto.getLandmarkLikeNo())
                .landmarkNo(landmarkNo)
                .userId(userId)
                .isLike(dto.isLike())
                .build();

        return entity;
    }
}
