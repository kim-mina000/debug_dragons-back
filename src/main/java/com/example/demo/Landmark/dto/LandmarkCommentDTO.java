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

    String writer;

    String landmarkCommentContent;

    LocalDateTime landmarkCommentRegDate;
}
