package com.example.demo.course.entity;

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
public class CourseLandmark extends BaseEntity {

    @Id
    String courseNo;

//  유저 아이디 (외래키)
    @ManyToOne
    Member writer;

//  여행지 코스 작성시간

//  폴더명
    @Column(length = 20)
    String category;
}
