package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.Landmark_commentDTO;
import com.example.demo.Landmark.entity.Landmark_comment;

public interface Landmark_likeService {
    default Landmark_commentDTO dtoToEntity(Landmark_comment entity){

        Landmark_commentDTO dto = Landmark_commentDTO.builder()
                .landmark_comment_no(entity.getLandmark_comment_no())
                .landmark_no(entity.getLandmark_no())
                .user_id(entity.getUser_id())
                .landmark_comment_content(entity.getLandmark_comment_content())
                .landmark_comment_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default Landmark_comment entityToDto(Landmark_commentDTO dto){

        Landmark_comment entity = Landmark_comment.builder()
                .landmark_comment_no(dto.getLandmark_comment_no())
                .landmark_no(dto.getLandmark_no())
                .user_id(dto.getUser_id())
                .landmark_comment_content(dto.getLandmark_comment_content())
                .build();

        return entity;
    }
}
