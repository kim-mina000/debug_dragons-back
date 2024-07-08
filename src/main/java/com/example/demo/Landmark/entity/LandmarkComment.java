package com.example.demo.Landmark.entity;

import com.example.demo.member.entity.BaseEntity;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandmarkComment extends BaseEntity {

//  여행지 댓글 고유값
    @Id
//    @GeneratedValue(strategy =GenerationType.IDENTITY)
//    ↑위 어노테이션 있으면 테이블 생성안됨 기본키 어쩌구 오류남
//    주석처리시 댓글테이블 하나 만들어짐, 그 이후에는 기본키 중복 오류
    int landmarkCommentNo;

//  여행지 고유값 (외래키)
    @ManyToOne
    Landmark landmarkNo;

//  유저 아이디 (외래키)
    @ManyToOne
    Member writer;

//  여행지 댓글 내용
    @Column(length = 11,nullable = false)
    String landmarkCommentContent;

// 여행지 댓글 작성시간

}
