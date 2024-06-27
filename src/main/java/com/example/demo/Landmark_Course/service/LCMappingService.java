package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark_Course.dto.LCMappingDTO;
import com.example.demo.Landmark_Course.entity.LCMapping;

public interface LCMappingService {

    default LCMappingDTO entityToDto (LCMapping entity){

        LCMappingDTO dto = LCMappingDTO.builder()
                .landmark_no(entity.getLandmark_no())
                .course_no(entity.getCourse_no())
                .order(entity.getOrder())
                .is_save(entity.is_save())
                .build();

        return dto;

    }

    default LCMapping dtoToEntity (LCMappingDTO dto){

        LCMapping entity = LCMapping.builder()
                .landmark_no(dto.getLandmark_no())
                .course_no(dto.getCourse_no())
                .order(dto.getOrder())
                .is_save(dto.is_save())
                .build();

        return entity;
    }

}
