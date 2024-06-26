package com.example.demo.Landmark.entity;

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
public class Landmark_like {


    //  여행지 idx
    @Id
    int landmark_like_no;

    //  여행지 고유값 (외래키)
    @Column(length = 11)
    String landmark_no;

    //  유저 아이디 (외래키)
    @Column(length = 11)
    String user_id;

}
