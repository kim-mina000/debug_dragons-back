package com.example.demo.course.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course_commentDTO {

    int course_comment_no;

    int course_no;

    String user_id;

    String course_comment_content;

    LocalDateTime course_comment_regDate;
}
