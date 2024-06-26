package com.example.demo.course.service;

import com.example.demo.Landmark.dto.Landmark_likeDTO;
import com.example.demo.Landmark.entity.Landmark_like;

public interface Course_likeService {

    default Landmark_likeDTO dtoToEntity(Landmark_like entity){

        Landmark_likeDTO dto = Landmark_likeDTO.builder()
                .landmark_like_no(entity.getLandmark_like_no())
                .landmark_no(entity.getLandmark_no())
                .user_id(entity.getUser_id())
                .build();

        return dto;
    }

    default Landmark_like entityToDto(Landmark_likeDTO dto){

        Landmark_like entity = Landmark_like.builder()
                .landmark_like_no(dto.getLandmark_like_no())
                .landmark_no(dto.getLandmark_no())
                .user_id(dto.getUser_id())
                .build();

        return entity;
    }
}
