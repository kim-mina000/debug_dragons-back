package com.example.demo.member.entity;

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

public class Member extends BaseEntity{

    @Id(length = 50)
    String user_id;

    @Column(length = 100, nullable = false)
    String user_name;

    @Column(length = 100, nullable = false)
    String user_pw;

    @Column(length = 255)
    String user_profile_image;

    @Column(length = 1000)
    String user_profile_image_path;

    @Column(length = 100, nullable = false)
    Boolean user_role;

}
