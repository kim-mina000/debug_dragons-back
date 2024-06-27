package com.example.demo.Landmark.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkLikeDTO {

    int landmarkLikeNo;

    String landmarkNo;

    String userId;
}
