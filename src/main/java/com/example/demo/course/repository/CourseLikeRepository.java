package com.example.demo.course.repository;

import com.example.demo.course.entity.CourseLandmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLikeRepository extends JpaRepository<CourseLandmark, Integer> {
}