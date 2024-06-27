package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.member.entity.Member;

public interface LandmarkService {

    default LandmarkDTO dtoToEntity(Landmark entity){


        LandmarkDTO dto = LandmarkDTO.builder()
                .landmarkNo(entity.getLandmarkNo())
                .userId(entity.getWriter().toString())
                .landmarkOrigin(entity.isLandmarkOrigin())
                .landmarkName(entity.getLandmarkName())
                .landmarkAddress(entity.getLandmarkAddress())
                .landmarkPhone(entity.getLandmarkPhone())
                .landmarkShortDesc(entity.getLandmarkShortDesc())
                .landmarkDesc(entity.getLandmarkDesc())
                .longitude(entity.getLongitude())
                .latitude(entity.getLatitude())
                .landmarkImgPath(entity.getLandmarkImgPath())
                .build();

        return dto;
    }

    default Landmark entityToDto(LandmarkDTO dto){

        Member member = Member.builder().userId(dto.getUserId()).build();

        Landmark entity = Landmark.builder()
                .landmarkNo(dto.getLandmarkNo())
                .writer(member)
                .landmarkOrigin(dto.isLandmarkOrigin())
                .landmarkName(dto.getLandmarkName())
                .landmarkAddress(dto.getLandmarkAddress())
                .landmarkPhone(dto.getLandmarkPhone())
                .landmarkShortDesc(dto.getLandmarkShortDesc())
                .landmarkDesc(dto.getLandmarkDesc())
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .landmarkImgPath(dto.getLandmarkImgPath())
                .build();

        return entity;
    }
}
