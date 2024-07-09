package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkCommentDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkComment;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface LandmarkCommentService {

//    게시물 기준 댓글목록 조회메소드
    List<LandmarkCommentDTO> getListByLandmarkNo(int landmarkNo);

//    새로운댓글등록
    int register(LandmarkCommentDTO dto);

//    특정게게시물삭제
    boolean remove(int no);

    default LandmarkComment dtoToEntity(LandmarkCommentDTO dto){

        Landmark landmark = Landmark.builder().landmarkNo(dto.getLandmarkNo()).build();

        Member member = Member.builder().userId(dto.getWriter()).build();
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
                .writer(entity.getWriter().getUserId())
                .landmarkCommentContent(entity.getLandmarkCommentContent())
                .build();

        return dto;
//        테스트테스트

    }
}
