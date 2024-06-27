package com.example.demo.Landmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkTag {

    //  여행지 고유값 (외래키)

    @ManyToOne
    Landmark landmarkNo;

    //  태그네임
    @Id
    @Column(length = 11, nullable = false)
    String tagName;
}
