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

    int courseNo;

    String userId;

    LocalDateTime courseRegDate;
}
