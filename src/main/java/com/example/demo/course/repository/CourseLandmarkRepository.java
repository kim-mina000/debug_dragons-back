package com.example.demo.course.repository;

import com.example.demo.course.entity.CourseLandmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseLandmarkRepository extends JpaRepository<CourseLandmark, String> {


//    @Query(value = "SELECT * FROM COURSE_LANDMARK CL WHERE CL.WRITER_USER_ID = :userId", nativeQuery = false)
    @Query("SELECT cl FROM CourseLandmark cl WHERE cl.writer.userId = :userId")
    public List<CourseLandmark> readByUserId (@Param("userId") String userId);
}
