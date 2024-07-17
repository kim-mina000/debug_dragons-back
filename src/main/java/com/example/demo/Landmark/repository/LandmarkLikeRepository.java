package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LandmarkLikeRepository extends JpaRepository<LandmarkLike,Integer> {

//    특정 랜드마크와 사용자에 대한 좋아요 정보를 찾기 위한 메서드
    Optional<LandmarkLike> findByLandmarkNoAndUserId(Landmark landmark, Member userId);

//  사용자가 좋아요 한 모든 랜드마크 정보를 찾기
    List<LandmarkLike> findByUserId(Member member);

//    랜드마크 isLike가 true인 좋아요 갯수세기 ☆ landmark_no_landmark_no 실제외래키존재확인(네이티브 쿼리문 일 경우)
    @Query(value = "select count(*) from landmark_like where landmark_no_landmark_no= :landmark_no AND is_like = true", nativeQuery = true)
    int countIsLikeTrue(@Param("landmark_no")int landmarkNo);

//    사용자좋아요 여부(하트땜시)
    LandmarkLike findByUserIdAndIsLike(Member userId, boolean isLike);
}
