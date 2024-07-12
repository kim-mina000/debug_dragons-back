package com.example.demo.course.service;

import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.course.dto.CourseLikeDTO;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.entity.CourseLike;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface CourseLikeService {

    void toggleLikeCourse(CourseLandmark courseLandmark, Member member);

    List<CourseLike> getAllLikesByUser(Member userId);

    default CourseLike dtoToEntity(CourseLikeDTO dto){

        CourseLandmark couresLandmark = CourseLandmark.builder().courseNo(dto.getCourseNo()).build();

        Member member = Member.builder().userId(dto.getUserId()).build();

        CourseLike entity = CourseLike.builder()
                .courseLikeNo(dto.getCourseLikeNo())
                .courseNo(couresLandmark)
                .userId(member)
                .isLike(dto.isLike())
                .build();

        return entity;
    }

    default CourseLikeDTO entityToDTO(CourseLike entity){
        CourseLikeDTO dto = CourseLikeDTO.builder()
                .courseLikeNo(entity.getCourseLikeNo())
                .courseNo(entity.getCourseNo().getCourseNo())
                .userId(entity.getUserId().getUserId())
                .isLike(entity.isLike())
                .build();

        return dto;
    }

}
