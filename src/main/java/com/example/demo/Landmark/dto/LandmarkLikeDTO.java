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

    int landmarkNo;

    String userId;

    boolean isLike;
}
