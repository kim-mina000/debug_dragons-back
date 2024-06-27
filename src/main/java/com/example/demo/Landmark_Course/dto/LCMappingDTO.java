package com.example.demo.Landmark_Course.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LCMappingDTO {

    int landmarkNo;

    int courseNo;

    int order;

    boolean isSave;

}
