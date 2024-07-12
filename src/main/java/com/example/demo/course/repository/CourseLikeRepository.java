package com.example.demo.course.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.entity.CourseLike;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseLikeRepository extends JpaRepository<CourseLike, Integer> {

    // 특정 랜드마크와 사용자에 대한 좋아요 정보를 찾기 위한 메서드
    Optional<CourseLike> findByCourseNoAndUserId(CourseLandmark courseLandmark, Member userId);

    //  사용자가 좋아요 한 모든 랜드마크 정보를 찾기
    List<CourseLike> findByUserId(Member member);

    //    랜드마크 isLike가 true인 좋아요 갯수세기
    @Query(value = "select count(*) from course_like where landmark_no= :landmark_no AND is_like = true", nativeQuery = true)
    int countIsLikeTrue(@Param("landmark_no")int landmarkNo);

}