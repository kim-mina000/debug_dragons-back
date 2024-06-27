package com.example.demo.Landmark_Course.repository;

import com.example.demo.Landmark_Course.entity.LCMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LCMappingRepository extends JpaRepository<LCMapping, Serializable> {
}
