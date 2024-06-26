package com.example.demo.course.service;

import com.example.demo.course.dto.Course_commentDTO;
import com.example.demo.course.entity.Course_comment;

public interface Course_commentService {

    default Course_commentDTO entityToDto(Course_comment entity){

        Course_commentDTO dto = Course_commentDTO.builder()
                .course_comment_no(entity.getCourse_comment_no())
                .course_no(entity.getCourse_no())
                .user_id(entity.getUser_id())
                .course_comment_content(entity.getCourse_comment_content())
                .course_comment_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default Course_comment dtoToEntity(Course_commentDTO dto){

        Course_comment entity = Course_comment.builder()
                .course_comment_no(dto.getCourse_comment_no())
                .course_no(dto.getCourse_no())
                .user_id(dto.getUser_id())
                .course_comment_content(dto.getCourse_comment_content())
                .build();

        return entity;
    }
}
