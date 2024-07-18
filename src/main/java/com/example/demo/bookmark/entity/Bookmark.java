package com.example.demo.bookmark.entity;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.course.entity.CourseLandmark;
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
public class Bookmark {

    //  여행지 idx
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int bookmarkNo;

    //  여행지 코스 고유값 (외래키)
    @ManyToOne
    Member member;

    @ManyToOne
    Landmark landmark;


}
