package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkCommentDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkComment;
import com.example.demo.member.entity.Member;

public interface LandmarkCommentService {

    default LandmarkComment dtoToEntity(LandmarkCommentDTO dto){

        Landmark landmark = Landmark.builder().landmarkNo(dto.getLandmarkNo()).build();

        Member member = Member.builder().userId(dto.getUserId()).build();
        LandmarkComment entity = LandmarkComment.builder()
                .landmarkCommentNo(dto.getLandmarkCommentNo())
                .landmarkNo(landmark)
                .writer(member)
                .landmarkCommentContent(dto.getLandmarkCommentContent())
                .build();

        return entity;
    }

    default LandmarkCommentDTO entityToDto (LandmarkComment entity){

        LandmarkCommentDTO dto = LandmarkCommentDTO.builder()
                .landmarkCommentNo(entity.getLandmarkCommentNo())
                .landmarkNo(entity.getLandmarkNo().getLandmarkNo())
                .userId(entity.getWriter().getUserId())
                .landmarkCommentContent(entity.getLandmarkCommentContent())
                .build();

        return dto;

    }
}
