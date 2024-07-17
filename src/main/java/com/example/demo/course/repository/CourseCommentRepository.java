package com.example.demo.course.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.course.entity.CourseComment;
import com.example.demo.course.entity.CourseLandmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseCommentRepository extends JpaRepository<CourseComment, Integer> {

//    코스게시물 기준, 댓글리스트(쿼리메소드)
    List<CourseComment> findByCourseNo(CourseLandmark courseLandmark);

//    코스게시물 기준, 댓글을 모두 삭제
//    void deleteBycourseCommentNo(CourseLandmark courseLandmark);
}
