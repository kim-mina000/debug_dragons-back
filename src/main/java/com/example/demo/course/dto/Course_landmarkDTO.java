package com.example.demo.course.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course_landmarkDTO {

    int course_no;

    String user_id;

    LocalDateTime course_regDate;
}
