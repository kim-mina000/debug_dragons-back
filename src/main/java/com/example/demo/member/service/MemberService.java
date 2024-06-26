package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import org.springframework.data.domain.Page;

public interface MemberService {

    Page<MemberDTO> getList(int pageNumber);    //회원 목록조회

    boolean register(MemberDTO dto);    //회원등록;

    MemberDTO read(String id);  //회원 한놈 조회;

//    Entity -> DTO  몇버전 이후 부터 디폴트넣으면 일반 함수개능
    default MemberDTO entityToDto(Member entity){
        MemberDTO dto = MemberDTO.builder()
                .user_id(entity.getUser_id())
                .user_pw(entity.getUser_pw())
                .user_name(entity.getUser_name())
                .regDate(entity.getRegDate())
                .user_profile_image_path(entity.getUser_profile_image_path())
                .user_role(entity.getUser_role())
                .build();

        return dto;
    }

    default Member dtoToEntity(MemberDTO dto){
        Member entity = Member.builder()
                .user_id(dto.getUser_id())
                .user_pw(dto.getUser_pw())
                .user_name(dto.getUser_name())
                .regDate(dto.getRegDate())
                .user_profile_image_path(dto.getUser_profile_image_path())
                .user_role(dto.getUser_role())
                .build();
        return entity;
    }

}
