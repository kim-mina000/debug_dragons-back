package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark_Course.dto.LC_mappingDTO;
import com.example.demo.Landmark_Course.entity.LC_mapping;

public interface LC_mappingService {

    default LC_mappingDTO entityToDto (LC_mapping entity){

        LC_mappingDTO dto = LC_mappingDTO.builder()
                .landmark_no(entity.getLandmark_no())
                .course_no(entity.getCourse_no())
                .order(entity.getOrder())
                .is_save(entity.is_save())
                .build();

        return dto;

    }

    default LC_mapping dtoToEntity (LC_mappingDTO dto){

        LC_mapping entity = LC_mapping.builder()
                .landmark_no(dto.getLandmark_no())
                .course_no(dto.getCourse_no())
                .order(dto.getOrder())
                .is_save(dto.is_save())
                .build();

        return entity;
    }

}
