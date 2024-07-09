package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkComment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional  //SQL작업결과 commit
public interface LandmarkCommentRepository extends JpaRepository<LandmarkComment, Integer> {

//    게시물 기준, 댓글 리스트 조회(쿼리메소드)
    List<LandmarkComment> findByLandmarkNo(Landmark landmark);

//    게시물기준, 댓글을 모두 삭제
    void deleteByLandmarkNo(Landmark landmark);
}
