package com.example.demo.Landmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Landmark_tag {

    //  여행지 고유값 (외래키)
    @Column(length = 11, nullable = false)
    int landmark_no;

    //  태그네임
    @Column(length = 11, nullable = false)
    String tag_name;
}
