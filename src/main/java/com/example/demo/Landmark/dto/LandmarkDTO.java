package com.example.demo.Landmark.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkDTO {

    int landmarkNo;

    String userId;

    boolean landmarkOrigin;

    String landmarkName;

    String landmarkAddress;

    int landmarkPhone;

    String landmarkShortDesc;

    String landmarkDesc;

    String longitude;

    String latitude;

    String landmarkImagePath;
}
