package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberTagRepository extends JpaRepository<MemberTag, String> {

//    @Query(value = "select * from member_tag m where m.user_id_user_id =:userId",nativeQuery = false)
    @Query("SELECT m FROM MemberTag m WHERE m.userId = :userId")
    public List<MemberTag> getListByID(@Param("userId") Member userId);

}
