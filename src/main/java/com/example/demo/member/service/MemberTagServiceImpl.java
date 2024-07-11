package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.dto.MemberTagDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberTag;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.repository.MemberTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberTagServiceImpl implements MemberTagService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberTagRepository repository;

    @Override
    public List<MemberTagDTO> getList(String userId) {

        Optional<Member> result = memberRepository.findById(userId);

        if (result.isPresent()){
            List<MemberTag> entityList = repository.getListByID(result.get());
            List<MemberTagDTO> list = entityList.stream()
                    .map(entity -> entityToDto(entity))
                    .collect(Collectors.toList());
            return list;
        }

        return null;
    }

    @Override
    public void register(MemberTagDTO dto) {
        Member member = Member.builder().userId(dto.getUserId()).build();
        MemberTag entity = dtoToEntity(dto);
        entity.setUserId(member);

        repository.save(entity);
    }

    @Override
    public MemberTagDTO read(String userId) {
        Optional<MemberTag> result = repository.findById(userId);
        if (result.isPresent()){
            MemberTagDTO dto = entityToDto(result.get());
            return dto;
        }
        return null;
    }

    @Override
    public void removeAll(String userId) {
        Member member = Member.builder().userId(userId).build();
        List<MemberTag> result = repository.getListByID(member);

        for (MemberTag tag : result){
            repository.deleteById(tag.getMemberTag());
        }
    }
}
