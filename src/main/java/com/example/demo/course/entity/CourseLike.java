package com.example.demo.course.entity;

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
public class CourseLike {

    @Id
    int courseLikeNo;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    String userId;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    int courseNo;

}
