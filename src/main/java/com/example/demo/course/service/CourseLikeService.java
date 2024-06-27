package com.example.demo.course.service;

import com.example.demo.Landmark.dto.LandmarkLikeDTO;
import com.example.demo.Landmark.entity.LandmarkLike;

public interface CourseLikeService {

    default LandmarkLikeDTO dtoToEntity(LandmarkLike entity){

        LandmarkLikeDTO dto = LandmarkLikeDTO.builder()
                .landmark_like_no(entity.getLandmark_like_no())
                .landmark_no(entity.getLandmark_no())
                .user_id(entity.getUser_id())
                .build();

        return dto;
    }

    default LandmarkLike entityToDto(LandmarkLikeDTO dto){

        LandmarkLike entity = LandmarkLike.builder()
                .landmark_like_no(dto.getLandmark_like_no())
                .landmark_no(dto.getLandmark_no())
                .user_id(dto.getUser_id())
                .build();

        return entity;
    }
}
