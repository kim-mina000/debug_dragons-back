package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String> {

    //    아이디찾기 이름과 이메일로 조회 쿼리문 ( Q? 쿼리문작성시 DB저장된듯이 _스네이크기법으로 작성해야하나요?)
    @Query(value = "select user_id from member where user_name = :user_name AND user_email = :user_email", nativeQuery = true)
    String get(@Param("user_name") String userName, @Param("user_email") String userEmail);
}
