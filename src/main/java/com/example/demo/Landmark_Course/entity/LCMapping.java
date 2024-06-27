package com.example.demo.Landmark_Course.entity;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.course.entity.CourseLandmark;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LCMapping {

//  여행지 고유값 (외래키)
    @Column(length = 11,nullable = false)
    Landmark landmarkNo;

//  여행지 고유값 (외래키)
    @Column(length = 11,nullable = false)
    CourseLandmark courseNo;

//  여행코스 내부 순서
    @Id
    @Column(length = 11,nullable = false)
    int order;

//  마이 페이지 저장 여부
    @Column
    boolean isSave;

}
