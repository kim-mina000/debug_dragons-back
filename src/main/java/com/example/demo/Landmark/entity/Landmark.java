package com.example.demo.Landmark.entity;

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
public class Landmark {

//  여행지 idx
    @Id
    int landmark_no;

//  유저 아이디 (외래키)
    @Column(length = 11)
    String user_id;

//  여행지 정보 출저 (유저가 쓴글인지 받아온 데이터인지)
    @Column(length = 11,nullable = false)
    boolean landmark_origin;

//  여행지 이름
    @Column(length = 30,nullable = false)
    String landmark_name;

//  여행지 주소
    @Column(length = 255,nullable = false)
    String landmark_address;

//  여행지 전화번호
    @Column(length = 11)
    int landmark_phone;

//  여행지 간단소개
    @Column(length = 255)
    String landmark_short_desc;

//  여행지 소개글
    @Column(length = 1000)
    String landmart_desc;

//  경도
    @Column(length = 255,nullable = false)
    String longitude;

//  위도
    @Column(length = 255,nullable = false)
    String latitude;
}
