package com.example.demo.Landmark.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkDTO {

    int landmarkNo;

    int day;   //일차

    LocalTime time; //시간

    String writer;

    String landmarkName;

    String landmarkAddress;

    int landmarkPhone;

    String landmarkShortDesc;

    String landmarkDesc;

    String longitude;

    String latitude;

    LocalDateTime regDate;

    LocalDateTime modDate;

    boolean landmarkOrigin;

    String landmarkImgPath;     //파일이름

    // MultipartFile uploadFile;   //파일스트림
}
