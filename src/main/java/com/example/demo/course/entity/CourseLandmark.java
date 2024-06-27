package com.example.demo.course.entity;

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
public class CourseLandmark extends BaseEntity {

    @Id
    int courseNo;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    String userId;

//  여행지 코스 작성시간
}
