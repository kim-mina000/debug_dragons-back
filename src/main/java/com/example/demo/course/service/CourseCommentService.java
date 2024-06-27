package com.example.demo.course.service;

import com.example.demo.course.dto.CourseCommentDTO;
import com.example.demo.course.entity.CourseComment;

public interface CourseCommentService {

    default CourseCommentDTO entityToDto(CourseComment entity){

        CourseCommentDTO dto = CourseCommentDTO.builder()
                .course_comment_no(entity.getCourse_comment_no())
                .course_no(entity.getCourse_no())
                .user_id(entity.getUser_id())
                .course_comment_content(entity.getCourse_comment_content())
                .course_comment_regDate(entity.getRegDate())
                .build();

        return dto;
    }

    default CourseComment dtoToEntity(CourseCommentDTO dto){

        CourseComment entity = CourseComment.builder()
                .course_comment_no(dto.getCourse_comment_no())
                .course_no(dto.getCourse_no())
                .user_id(dto.getUser_id())
                .course_comment_content(dto.getCourse_comment_content())
                .build();

        return entity;
    }
}
