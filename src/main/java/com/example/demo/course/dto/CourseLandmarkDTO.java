package com.example.demo.course.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseLandmarkDTO {

    String courseNo;

    String userId;

    LocalDateTime courseRegDate;

    String category;
}
