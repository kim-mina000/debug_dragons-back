package com.example.demo.Landmark.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkDTO {

    int landmark_no;

    String user_id;

    boolean landmark_origin;

    String landmark_name;

    String landmark_address;

    int landmark_phone;

    String landmark_short_desc;

    String landmart_desc;

    String longitude;

    String latitude;

    String landmark_image_path;
}
