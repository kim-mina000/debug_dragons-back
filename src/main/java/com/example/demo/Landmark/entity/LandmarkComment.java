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
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int landmarkCommentNo;

//  여행지 고유값 (외래키)
    @ManyToOne
    Landmark landmarkNo;

//  유저 아이디 (외래키)
    @ManyToOne
    Member writer;

//  여행지 댓글 내용
    @Column(length = 500,nullable = false)
    String landmarkCommentContent;

// 여행지 댓글 작성시간

}
