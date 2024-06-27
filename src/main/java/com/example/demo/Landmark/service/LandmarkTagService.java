package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkCommentDTO;
import com.example.demo.Landmark.entity.LandmarkComment;

public interface LandmarkTagService {
    default LandmarkCommentDTO dtoToEntity(LandmarkComment entity){

        LandmarkCommentDTO dto = LandmarkCommentDTO.builder()
                .landmark_comment_no(entity.getLandmark_comment_no())
                .landmark_no(entity.getLandmark_no())
                .user_id(entity.getUser_id())
                .landmark_comment_content(entity.getLandmark_comment_content())
                .landmark_comment_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default LandmarkComment entityToDto(LandmarkCommentDTO dto){

        LandmarkComment entity = LandmarkComment.builder()
                .landmark_comment_no(dto.getLandmark_comment_no())
                .landmark_no(dto.getLandmark_no())
                .user_id(dto.getUser_id())
                .landmark_comment_content(dto.getLandmark_comment_content())
                .build();

        return entity;
    }
}
