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
public class Course_like {

    @Id
    int course_like_no;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    String user_id;

//  유저 아이디 (외래키)
    @Column(length = 11,nullable = false)
    int course_no;

}
