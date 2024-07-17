package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface LandmarkService {

//    랜드마크 등록
    LandmarkDTO register(LandmarkDTO dto);

//    랜드마크 목록 조회
    List<LandmarkDTO> getList();

//    아이디로 랜드마크 목록 조회
    List<LandmarkDTO> getListById(String userId);

//    랜드마크 상세 조회
    LandmarkDTO read(int no);

//    랜드마크 수정
    void modify(LandmarkDTO dto);

//    랜드마크 삭제
    int remove(int no);

//    글쓴이(writer) 랜드마크에 저장
    void saveLandmarkWithWriter(Landmark landmark, Member writer);

//    LCMapping에 저장 landmarkOrigin을 1로변경
    void changeLandmarkOrigin(int landmarkNo);

//    landmarkOrigin을 2로변경
    void changeLandmarkOrigin2(int landmarkNo);

//    landmarkAdress로 landmarkEntity접근
    LandmarkDTO readBylandmarkAddress(String adress);

//    PK로 landmarkDTO반환
    LandmarkDTO findById(int landmarkNo);

//    int landmarkOrigin 값으로 랜드마크 리스트 조회
    List<LandmarkDTO> getListByOrigin(int origin);

    default Landmark dtoToEntity(LandmarkDTO dto){
        Member member = Member.builder().userId(dto.getWriter()).build();

        Landmark entity = Landmark.builder()
                .landmarkNo(dto.getLandmarkNo())
                .landmarkDay(dto.getLandmarkDay())
                .landmarkTime(dto.getLandmarkTime())
                .writer(member)
                .landmarkOrigin(dto.getLandmarkOrigin())
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
                .landmarkDay(entity.getLandmarkDay())
                .landmarkTime(entity.getLandmarkTime())
                .writer(entity.getWriter().getUserId())
                .landmarkOrigin(entity.getLandmarkOrigin())
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
