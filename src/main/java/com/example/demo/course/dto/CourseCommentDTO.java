package com.example.demo.course.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseCommentDTO {

    int courseCommentNo;

    String courseNo;

    String userId;

    String courseCommentContent;

    LocalDateTime courseCommentRegDate;
}
