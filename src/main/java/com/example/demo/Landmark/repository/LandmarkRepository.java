package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LandmarkRepository extends JpaRepository<Landmark,Integer> {

//    SELECT * FROM Landmark L WHERE L.WRITER_USER_ID = "22"
//    SELECT l FROM Landmark l WHERE l.writerUserId = :userId
    @Query("select L from Landmark L where L.writer = :userId")
    public List<Landmark> selectByWriter(@Param("userId") Member member);

    @Query("select L from Landmark L where L.landmarkAddress = :adress")
    public Optional<Landmark> selectByAddress(@Param("adress") String landmarkAddress);

}
