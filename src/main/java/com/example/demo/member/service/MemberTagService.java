package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.dto.MemberTagDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberTag;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberTagService {

    List<MemberTagDTO> getList(String userId);  // 조회

    void register(MemberTagDTO dto); // 태그등록;

    MemberTagDTO read(String memberTag); // 하나 조회?

    void removeAll(String userId);



    default  MemberTagDTO entityToDto(MemberTag entity) {
        MemberTagDTO dto = MemberTagDTO.builder()
                .memberTag(entity.getMemberTag())
                .build();

        return dto;
    }

    default MemberTag dtoToEntity(MemberTagDTO dto) {

        MemberTag entity = MemberTag.builder()
                .memberTag(dto.getMemberTag())
                .build();

        return entity;
    }
}
