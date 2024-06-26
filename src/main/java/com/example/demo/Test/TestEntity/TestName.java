package com.example.demo.Test.TestEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TestName {

    @Id
    @Column(length = 10,nullable = false)
    String name;

}
