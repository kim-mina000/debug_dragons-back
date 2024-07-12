package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LandmarkLikeRepository extends JpaRepository<LandmarkLike,Integer> {
    //   특정 랜드마크와 사용자에 대한 좋아요 정보를 찾기 위한 메서드
    Optional<LandmarkLike> findByLandmarkNoAndUserId(Landmark landmark, Member userId);

//  사용자가 좋아요한 모든 랜드마크 정보를 찾기
    List<LandmarkLike> findByUserId(Member member);
}
