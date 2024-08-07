package com.example.demo.Landmark.entity;

import com.example.demo.member.entity.BaseEntity;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Landmark  extends BaseEntity {

//  여행지 idx
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int landmarkNo;

//  몇일 차 일정인지
    @Column
    int landmarkDay;

//  시간
    @Column
    LocalTime landmarkTime;

//  유저 아이디 (외래키)
    @ManyToOne
    Member writer;

//  여행지 이름
    @Column(length = 30,nullable = false)
    String landmarkName;

//  여행지 주소
    @Column(length = 255,nullable = false)
    String landmarkAddress;

//  여행지 전화번호
    @Column(length = 11)
    int landmarkPhone;

//  여행지 간단소개
    @Column(length = 255)
    String landmarkShortDesc;

//  여행지 소개글
    @Column(length = 1000)
    String landmarkDesc;

//  경도
    @Column(length = 255,nullable = false)
    String longitude;

//  위도
    @Column(length = 255,nullable = false)
    String latitude;

//  이미지 경로 : 첨부파일이름
    @Column(length = 1000)
    private String landmarkImgPath;

//  랜드마크출처 0=초기값, 1= 내가 저장하면 2=내가 공유하면
    @Column(length = 11,nullable = false)
    int landmarkOrigin;

}
