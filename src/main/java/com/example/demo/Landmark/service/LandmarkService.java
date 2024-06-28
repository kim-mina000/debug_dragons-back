package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface LandmarkService {

//    랜드마크 등록
    int register(LandmarkDTO dto);

//    랜드마크 목록 조회
    List<LandmarkDTO> getList();

//    랜드마크 상세 조회
    LandmarkDTO read(int no);

//    랜드마크 수정
    void modify(LandmarkDTO dto);

//    랜드마크 삭제
    int remove(int no);

    default Landmark dtoToEntity(LandmarkDTO dto){
        Member member = Member.builder().userId(dto.getWriter()).build();

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
        return  entity;


    }

    default LandmarkDTO entityToDto(Landmark entity){

         LandmarkDTO dto = LandmarkDTO.builder()
                .landmarkNo(entity.getLandmarkNo())
                .writer(entity.getWriter().getUserId())
                .landmarkOrigin(entity.isLandmarkOrigin())
                .landmarkName(entity.getLandmarkName())
                .landmarkAddress(entity.getLandmarkAddress())
                .landmarkPhone(entity.getLandmarkPhone())
                .landmarkShortDesc(entity.getLandmarkShortDesc())
                .landmarkDesc(entity.getLandmarkDesc())
                .longitude(entity.getLongitude())
                .latitude(entity.getLatitude())
                .landmarkImgPath(entity.getLandmarkImgPath())  // 이미지경로추가
                .build();

        return dto;
    }
}
