package com.example.demo.Landmark.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Landmark_commentDTO {

    int landmark_comment_no;

    int landmark_no;

    String user_id;

    String landmark_comment_content;

    LocalDateTime landmark_comment_regDate;
}
