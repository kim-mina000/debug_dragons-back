package com.example.demo.Landmark_Course.entity;

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
public class Landmark_course_mapping {

//  여행지 고유값 (외래키)
    @Column(length = 11,nullable = false)
    int landmark_no;

//  여행지 고유값 (외래키)
    @Column(length = 11,nullable = false)
    int course_no;

//  여행코스 내부 순서
    @Column(length = 11,nullable = false)
    int order;

//  마이 페이지 저장 여부
    @Column
    boolean is_save;

}
