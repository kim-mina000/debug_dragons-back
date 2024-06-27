package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.LandmarkTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LandmarkTagRepository extends JpaRepository<LandmarkTag, Serializable> {
}
