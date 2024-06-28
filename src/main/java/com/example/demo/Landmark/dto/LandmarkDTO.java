package com.example.demo.Landmark.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkDTO {

    int landmarkNo;

    String writer;

    boolean landmarkOrigin;

    String landmarkName;

    String landmarkAddress;

    int landmarkPhone;

    String landmarkShortDesc;

    String landmarkDesc;

    String longitude;

    String latitude;

    LocalDateTime regDate;

    LocalDateTime modDate;

    String landmarkImgPath;     //파일이름

    MultipartFile uploadFile;   //파일스트림
}
