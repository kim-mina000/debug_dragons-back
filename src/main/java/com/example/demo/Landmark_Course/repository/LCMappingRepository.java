package com.example.demo.Landmark_Course.repository;

import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.course.entity.CourseLandmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface LCMappingRepository extends JpaRepository<LCMapping, Serializable> {

//    SELECT * FROM LCMAPPING L JOIN LANDMARK L2 ON L.LANDMARK_NO_LANDMARK_NO = L2.LANDMARK_NO JOIN `member` m ON L2.WRITER_USER_ID = m.USER_ID WHERE m.USER_ID ="22"
//    @Query("SELECT l FROM LCMAPPING l JOIN l.landmark l2 JOIN l2.writer m WHERE m.userId = :userId ")
//    @Query(value = "SELECT * FROM LCMAPPING L JOIN LANDMARK L2 ON L.LANDMARK_NO_LANDMARK_NO = L2.LANDMARK_NO JOIN `member` m ON L2.WRITER_USER_ID = m.USER_ID WHERE m.USER_ID = :userId ", nativeQuery = false)
//    public List<LCMapping> readByUserId(@Param("userId") String userId);

//    SELECT * FROM LCMAPPING L WHERE L.COURSE_NO_COURSE_NO = :courseNo
    @Query("SELECT L FROM LCMapping L WHERE L.courseNo = :courseNo")
    public List<LCMapping> findByCourseNo(@Param("courseNo") CourseLandmark courseNo);
//
//
//
//    //작성자 필드를 기준으로 게시물을 삭제하는 메소드 추가
//    @Modifying //@Query로 INSERT, UPDATE, DELETE를 작성시 선언
//    @Query("delete from Board b where b.writer = :member")
//    public void deleteWriter(@Param("member") Member member);
}
