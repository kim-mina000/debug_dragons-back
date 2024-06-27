package com.example.demo.course.entity;

import com.example.demo.member.entity.Member;
import jakarta.persistence.Column;
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
public class CourseLike {

    @Id
    int courseLikeNo;

//  유저 아이디 (외래키)
    @ManyToOne
    CourseLandmark courseNo;

//  유저 아이디 (외래키)
    @ManyToOne
    Member userId;

}
