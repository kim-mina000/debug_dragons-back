package com.example.demo.Landmark.service;


import com.example.demo.Landmark.dto.LandmarkLikeDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.member.entity.Member;

public interface LandmarkLikeService {

    default LandmarkLikeDTO entityToDto (LandmarkLike entity){

        Member member = entity.getUserId();

        LandmarkLikeDTO dto = LandmarkLikeDTO.builder()
                .landmarkLikeNo(entity.getLandmarkLikeNo())
                .landmarkNo(entity.getLandmarkLikeNo())
                .userId(member.toString())
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
                .build();

        return entity;
    }
}
