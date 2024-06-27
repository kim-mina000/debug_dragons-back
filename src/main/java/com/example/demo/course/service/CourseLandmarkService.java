package com.example.demo.course.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;

public interface CourseLandmarkService {

    default CourseLandmarkDTO entityToDto(CourseLandmark entity){

        CourseLandmarkDTO dto = CourseLandmarkDTO.builder()
                .user_id(entity.getUser_id())
                .course_no(entity.getCourse_no())
                .course_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default CourseLandmark dtoToEntity(CourseLandmarkDTO dto){

        CourseLandmark entity = CourseLandmark.builder()
                .course_no(dto.getCourse_no())
                .user_id(dto.getUser_id())
                .build();

        return entity;
    }
}
