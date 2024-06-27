//package com.example.demo.Landmark.service;
//
//import com.example.demo.Landmark.dto.LandmarkTagDTO;
//import com.example.demo.Landmark.entity.Landmark;
//import com.example.demo.Landmark.entity.LandmarkTag;
//
//public interface LandmarkTagService {
//
//    default LandmarkTagDTO entityToDto (LandmarkTag entity){
//
//        LandmarkTagDTO dto = LandmarkTagDTO.builder()
//                .landmarkNo(entity.getLandmarkNo().getLandmarkNo())
//                .tagName(entity.getTagName())
//                .build();
//
//        return dto;
//    }
//
//
//    default LandmarkTag dtoToEntity(LandmarkTagDTO dto){
//
//        Landmark landmark = Landmark.builder().landmarkNo(dto.getLandmarkNo()).build();
//
//        LandmarkTag entity = LandmarkTag.builder()
//                .landmarkNo(landmark)
//                .tagName(dto.getTagName())
//                .build();
//
//        return entity;
//    }
//}
