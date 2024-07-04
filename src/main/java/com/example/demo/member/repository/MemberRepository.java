package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MemberRepository extends JpaRepository<Member, String> {

//    아이디찾기: 이름과 이메일로 조회 쿼리문
    @Query(value = "select user_id from member where user_name = :user_name AND user_email = :user_email", nativeQuery = true)
    String getId(@Param("user_name") String userName, @Param("user_email") String userEmail);

//    비밀번호 찾기: 아이디, 이름, 이메일로 확인
    @Query(value = "select user_pw from Member where user_id = :user_id AND user_email = :user_email AND user_name = :user_name", nativeQuery = true)
    String getPw(@Param("user_id") String userId, @Param("user_name") String userName, @Param("user_email") String userEmail);

//    비밀번호 임시변경
    @Modifying
    @Query(value = "UPDATE Member SET user_pw = :user_pw WHERE user_id = :user_id", nativeQuery = true)
    void updatePassword(@Param("user_id") String userId, @Param("user_pw") String userPw);

}
