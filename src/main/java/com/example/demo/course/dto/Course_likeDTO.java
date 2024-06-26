package com.example.demo.course.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course_likeDTO {

    int course_like_no;

    String user_id;

    int course_no;
}
