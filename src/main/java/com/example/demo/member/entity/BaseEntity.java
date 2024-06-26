package com.example.demo.member.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {

    @CreatedDate    //생성감지
    LocalDateTime regDate;

    @CreatedDate
    LocalDateTime modDate;


}
