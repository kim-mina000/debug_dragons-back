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

    int courseNo;

    String userId;

    String courseCommentContent;

    LocalDateTime courseCommentRegDate;
}
