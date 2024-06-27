//package com.example.demo.course.service;
//
//import com.example.demo.course.dto.CourseCommentDTO;
//import com.example.demo.course.entity.CourseComment;
//import com.example.demo.course.entity.CourseLandmark;
//import com.example.demo.member.entity.Member;
//
//public interface CourseCommentService {
//
//    default CourseComment dtoToEntity(CourseCommentDTO dto){
//
//        CourseLandmark courseLandmark = CourseLandmark.builder().courseNo(dto.getCourseNo()).build();
//
//        Member member = Member.builder().userId(dto.getUserId()).build();
//
//        CourseComment entity = CourseComment.builder()
//                .courseCommentNo(dto.getCourseCommentNo())
//                .courseNo(courseLandmark)
//                .userId(member)
//                .courseCommentContent(dto.getCourseCommentContent())
//                .build();
//
//        return entity;
//
//    }
//
//    default CourseCommentDTO entityTodto(CourseComment entity){
//        CourseCommentDTO dto = CourseCommentDTO.builder()
//                .courseCommentNo(entity.getCourseCommentNo())
//                .courseNo(entity.getCourseNo().getCourseNo())
//                .userId(entity.getUserId().getUserId())
//                .courseCommentContent(entity.getCourseCommentContent())
//                .build();
//
//        return dto;
//
//    }
//}
