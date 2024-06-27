package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark_Course.dto.LCMappingDTO;
import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.course.entity.CourseLandmark;

public interface LCMappingService {

    default LCMappingDTO entityToDto (LCMapping entity){

        LCMappingDTO dto = LCMappingDTO.builder()
                .landmarkNo(entity.getLandmarkNo().getLandmarkNo())
                .courseNo(entity.getCourseNo().getCourseNo())
                .order(entity.getOrder())
                .isSave(entity.isSave())
                .build();

        return dto;

    }

    default LCMapping dtoToEntity (LCMappingDTO dto){

        Landmark landmark = Landmark.builder().landmarkNo(dto.getLandmarkNo()).build();
        CourseLandmark courseLandmark = CourseLandmark.builder().courseNo(dto.getCourseNo()).build();

        LCMapping entity = LCMapping.builder()
                .landmarkNo(landmark)
                .courseNo(courseLandmark)
                .order(dto.getOrder())
                .isSave(dto.isSave())
                .build();

        return entity;
    }

}
