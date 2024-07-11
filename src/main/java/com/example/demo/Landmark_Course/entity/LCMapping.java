package com.example.demo.Landmark_Course.entity;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.course.entity.CourseLandmark;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LCMapping {

//  idx
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int LCMappingNo;

//  여행지 고유값 (외래키)
    @ManyToOne
    Landmark landmarkNo;

//  여행지 고유값 (외래키)
    @ManyToOne
    CourseLandmark courseNo;

//  여행코스 내부 순서
    @Column(length = 11,nullable = false)
    int orderNumber;

//   마이페이지 저장 여부
    @Column(length = 11,nullable = false)
    boolean isSave;

//    카테고리
    @Column(length = 20)
    String category;

}
