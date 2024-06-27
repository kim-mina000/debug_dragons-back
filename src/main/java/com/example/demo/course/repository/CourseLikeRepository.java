package com.example.demo.course.repository;

import com.example.demo.course.entity.CourseLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLikeRepository extends JpaRepository<CourseLike, Integer> {
}
