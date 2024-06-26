package com.example.demo.Landmark.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Landmark_likeDTO {

    int landmark_like_no;

    String landmark_no;

    String user_id;
}
