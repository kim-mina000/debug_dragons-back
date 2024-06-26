package com.example.demo.Landmark.entity;

import com.example.demo.member.entity.BaseEntity;
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
public class Landmark_comment extends BaseEntity {

//  여행지 댓글 고유값
    @Id
    int landmark_comment_no;

//  여행지 고유값 (외래키)
    @Column(length = 11,nullable = false)
    int landmark_no;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    String user_id;

//  여행지 댓글 내용
    @Column(length = 11,nullable = false)
    String landmark_comment_content;
    
// 여행지 댓글 작성시간
}
