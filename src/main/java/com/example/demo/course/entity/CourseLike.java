package com.example.demo.course.entity;

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
public class CourseLike {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int courseLikeNo;

//  유저 아이디 (외래키)
    @ManyToOne
    CourseLandmark courseNo;

//  유저 아이디 (외래키)
    @ManyToOne
    Member userId;

    @Column(length = 20)
    boolean isLike;

}
