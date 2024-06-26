package com.example.demo.member.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value ={AuditingEntityListener.class})
public class BaseEntity {

    @CreatedDate
    LocalDateTime regDate;
//

}
