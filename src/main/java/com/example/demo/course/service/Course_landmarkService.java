package com.example.demo.course.service;

import com.example.demo.course.dto.Course_landmarkDTO;
import com.example.demo.course.entity.Course_landmark;

public interface Course_landmarkService {

    default Course_landmarkDTO entityToDto(Course_landmark entity){

        Course_landmarkDTO dto = Course_landmarkDTO.builder()
                .user_id(entity.getUser_id())
                .course_no(entity.getCourse_no())
                .course_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default Course_landmark dtoToEntity(Course_landmarkDTO dto){

        Course_landmark entity = Course_landmark.builder()
                .course_no(dto.getCourse_no())
                .user_id(dto.getUser_id())
                .build();

        return entity;
    }
}
