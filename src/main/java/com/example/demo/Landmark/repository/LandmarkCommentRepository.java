package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.LandmarkComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkCommentRepository extends JpaRepository<LandmarkComment, Integer> {
}
