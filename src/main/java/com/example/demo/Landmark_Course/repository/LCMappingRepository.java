package com.example.demo.Landmark_Course.repository;

import com.example.demo.Landmark_Course.entity.LCMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LCMappingRepository extends JpaRepository<LCMapping, Serializable> {

//    SELECT * FROM LCMAPPING L JOIN LANDMARK L2 ON L.LANDMARK_NO_LANDMARK_NO = L2.LANDMARK_NO JOIN `member` m ON L2.WRITER_USER_ID = m.USER_ID WHERE m.USER_ID ="22"
//    @Query("SELECT l FROM LCMAPPING l JOIN l.landmark l2 JOIN l2.writer m WHERE m.userId = :userId ")
//    @Query(value = "SELECT * FROM LCMAPPING L JOIN LANDMARK L2 ON L.LANDMARK_NO_LANDMARK_NO = L2.LANDMARK_NO JOIN `member` m ON L2.WRITER_USER_ID = m.USER_ID WHERE m.USER_ID = :userId ", nativeQuery = false)
//    public List<LCMapping> readByUserId(@Param("userId") String userId);
}
