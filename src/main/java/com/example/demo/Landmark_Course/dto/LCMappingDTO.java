package com.example.demo.Landmark_Course.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LCMappingDTO {

    int LCMappingNo;

    int landmarkNo;

    String courseNo;

    int orderNumber;

    boolean isSave;

    String category;

}
