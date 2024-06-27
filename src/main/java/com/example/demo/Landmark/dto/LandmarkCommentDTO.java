package com.example.demo.Landmark.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkCommentDTO {

    int landmarkCommentNo;

    int landmarkNo;

    String userId;

    String landmarkCommentContent;

    LocalDateTime landmarkCommentRegDate;
}
