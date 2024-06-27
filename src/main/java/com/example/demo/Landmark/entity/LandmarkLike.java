package com.example.demo.Landmark.entity;

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
public class LandmarkLike {


    //  여행지 idx
    @Id
    int landmark_likeNo;

    //  여행지 고유값 (외래키)
    @ManyToOne
    Landmark landmarkNo;

    //  유저 아이디 (외래키)
    @ManyToOne
    Landmark userId;

}
