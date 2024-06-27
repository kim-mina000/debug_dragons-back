//package com.example.demo.course.service;
//
//import com.example.demo.Landmark.dto.LandmarkLikeDTO;
//import com.example.demo.Landmark.entity.LandmarkLike;
//import com.example.demo.course.dto.CourseLikeDTO;
//import com.example.demo.course.entity.CourseLandmark;
//import com.example.demo.course.entity.CourseLike;
//import com.example.demo.member.entity.Member;
//
//public interface CourseLikeService {
//
//    default CourseLike dtoToEntity(CourseLikeDTO dto){
//
//        CourseLandmark couresLandmark = CourseLandmark.builder().courseNo(dto.getCourseNo()).build();
//
//        Member member = Member.builder().userId(dto.getUserId()).build();
//
//        CourseLike entity = CourseLike.builder()
//                .courseLikeNo(dto.getCourseLikeNo())
//                .courseNo(couresLandmark)
//                .userId(member)
//                .build();
//
//        return entity;
//    }
//
//    default CourseLikeDTO entityToDTO(CourseLike entity){
//        CourseLikeDTO dto = CourseLikeDTO.builder()
//                .courseLikeNo(entity.getCourseLikeNo())
//                .courseNo(entity.getCourseNo().getCourseNo())
//                .userId(entity.getUserId().getUserId())
//                .build();
//
//        return dto;
//    }
//
//}
