package com.example.demo.Test.TestRepository;

import com.example.demo.Test.TestEntity.TestName;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository extends JpaRepository<TestName,String> {
}
