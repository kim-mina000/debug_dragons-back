package com.example.demo.course.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface CourseLandmarkService {

    // 등록
    public void register(CourseLandmarkDTO dto);

    // 아이디로 검색 리스트 반환
    public List<CourseLandmarkDTO> readByUserId(String userId);

    // PK로 찾기
    public CourseLandmarkDTO findById(String courseNo);

    default CourseLandmark dtoToEntity(CourseLandmarkDTO dto){

        Member member = Member.builder().userId(dto.getUserId()).build();

        CourseLandmark entity = CourseLandmark.builder()
                .courseNo(dto.getCourseNo())
                .writer(member)
                .build();

        return entity;
    }

    default CourseLandmarkDTO entityToDto(CourseLandmark entity){
        CourseLandmarkDTO dto = CourseLandmarkDTO.builder()
                .courseNo(entity.getCourseNo())
                .userId(entity.getWriter().getUserId())
                .build();
        return dto;
    }
}
