package com.example.demo.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity{

    @Id
    @Column(length = 20)
    String userId;

    @Column(length = 100, nullable = false)
    String userPw;

    @Column(length = 100, nullable = false)
    String userName;

//    @Lob
    @Column(length = 1000)
    String userProfileImagePath;

    @Column(length = 100, nullable = false)
    String userRole;

    @Column(length = 100)
    String userEmail;

    @Column(length = 30)
    String nickName;

    @Column(length = 20)
    String phone;

    @Column(length = 30)
    LocalDate birth;

}
