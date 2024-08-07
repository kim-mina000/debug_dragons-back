package com.example.demo.Landmark.entity;

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
public class LandmarkLike {


    //  여행지 idx
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int landmarkLikeNo;

    //  여행지 고유값 (외래키)
    @ManyToOne
    Landmark landmarkNo;

    //  유저 아이디 (외래키)
    @ManyToOne
    Member userId;

    @Column(length = 20)
    boolean isLike;

}
