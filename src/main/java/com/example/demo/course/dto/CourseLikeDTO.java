package com.example.demo.course.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseLikeDTO {

    int courseLikeNo;

    String userId;

    int courseNo;
}
