package com.example.demo.course.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.member.entity.Member;

public interface CourseLandmarkService {

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
