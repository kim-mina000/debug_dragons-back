package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import org.springframework.data.domain.Page;

public interface MemberService {

    Page<MemberDTO> getList(int pageNumber);    //회원 목록조회

    boolean register(MemberDTO dto);    //회원등록;

    MemberDTO read(String id);  //회원 한놈 조회;

    String findId(String userName, String userEmail);   //ID 찾기

    boolean checkDuplicate(String id);

//    Entity -> DTO  몇버전 이후 부터 디폴트넣으면 일반 함수가능
    default MemberDTO entityToDto(Member entity){
        MemberDTO dto = MemberDTO.builder()
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .userName(entity.getUserName())
                .regDate(entity.getRegDate())
                .userProfileImagePath(entity.getUserProfileImagePath())
                .userRole(entity.getUserRole())
                .userEmail(entity.getUserEmail())
                .build();

        return dto;
    }

    default Member dtoToEntity(MemberDTO dto){
        Member entity = Member.builder()
                .userId(dto.getUserId())
                .userPw(dto.getUserPw())
                .userName(dto.getUserName())
                .userProfileImagePath(dto.getUserProfileImagePath())
                .userRole(dto.getUserRole())
                .userEmail(dto.getUserEmail())
                .build();

        return entity;
    }

}
