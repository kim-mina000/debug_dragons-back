package com.example.demo.Landmark_Course.repository;

import com.example.demo.Landmark_Course.entity.LC_mapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LC_mappingRepository extends JpaRepository<LC_mapping, Serializable> {
}
