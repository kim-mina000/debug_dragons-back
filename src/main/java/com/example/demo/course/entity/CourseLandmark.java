package com.example.demo.course.entity;

import com.example.demo.member.entity.BaseEntity;
import com.example.demo.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    Member writer;

//  여행지 코스 작성시간
}
