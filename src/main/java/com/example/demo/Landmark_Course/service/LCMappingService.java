package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark_Course.dto.LCMappingDTO;
import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;

import java.util.List;


public interface LCMappingService {


    // 등록
    public int register(LCMappingDTO dto);

    // courseNo으로 데이터 가져오기
    public List<LCMappingDTO> read(CourseLandmarkDTO courseNo);

    default LCMappingDTO entityToDto (LCMapping entity){

        LCMappingDTO dto = LCMappingDTO.builder()
                .landmarkNo(entity.getLandmarkNo().getLandmarkNo())
                .courseNo(entity.getCourseNo().getCourseNo())
                .orderNumber(entity.getOrderNumber())
                .isSave(entity.isSave())
                .LCMappingNo(entity.getLCMappingNo())
                .category(entity.getCategory())
                .build();

        return dto;

    }

    default LCMapping dtoToEntity (LCMappingDTO dto){

        Landmark landmark = Landmark.builder()
                .landmarkNo(dto.getLandmarkNo())
                .build();

        CourseLandmark courseLandmark = CourseLandmark.builder().courseNo(dto.getCourseNo()).build();


        LCMapping entity = LCMapping.builder()
                .landmarkNo(landmark)
                .courseNo(courseLandmark)
                .orderNumber(dto.getOrderNumber())
                .LCMappingNo(dto.getLCMappingNo())
                .category(dto.getCategory())
                .isSave(dto.isSave())
                .build();

        return entity;
    }

}
