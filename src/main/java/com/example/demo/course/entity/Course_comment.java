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
public class Course_comment extends BaseEntity {

    //  여행지 idx
    @Id
    int course_comment_no;

    //  여행지 코스 고유값 (외래키)
    @Column(length = 11,nullable = false)
    int course_no;

    //  유저아이디 (외래키)
    @Column(length = 11,nullable = false)
    String user_id;

    //  여행지 코스 댓글 내용
    @Column(length = 255,nullable = false)
    String course_comment_content;

    //  여행지 코스 댓글 작성시간


}
