package com.example.demo.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(value ={AuditingEntityListener.class})

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member extends BaseEntity{

    @Id
    @Column(length = 20)
    String user_id;

    @Column(length = 100, nullable = false)
    String user_name;

    @Column(length = 100, nullable = false)
    String user_pw;

    @Column(length = 1000)
    String user_profile_image_path;

    @Column(length = 100, nullable = false)
    Boolean user_role;

}
