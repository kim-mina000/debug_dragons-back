package com.example.demo.course.entity;

import com.example.demo.member.entity.BaseEntity;
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
public class CourseComment extends BaseEntity {

    //  여행지 idx
    @Id
    int courseCommentNo;

    //  여행지 코스 고유값 (외래키)
    @ManyToOne
    CourseLandmark courseNo;

    //  유저아이디 (외래키)
    @ManyToOne
    Member userId;

    //  여행지 코스 댓글 내용
    @Column(length = 255,nullable = false)
    String courseCommentContent;

    //  여행지 코스 댓글 작성시간


}
