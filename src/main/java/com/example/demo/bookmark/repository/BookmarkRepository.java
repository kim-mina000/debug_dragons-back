package com.example.demo.bookmark.repository;

import com.example.demo.bookmark.entity.Bookmark;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

    @Query("SELECT B FROM Bookmark B WHERE B.member = :member")
    List<Bookmark> findByUserId(@Param("member") Member member);

    @Query("SELECT B FROM Bookmark B WHERE B.landmark = :no")
    List<Bookmark> findAllById(@Param("no") int no);

    
    // 선생님저를차가운사회에 버리지말아주세요 ,,이거 유기에요
}
