package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<MemberDTO> getList(int pageNumber) {
        int pageIndex = (pageNumber ==0) ? 0 : pageNumber - 1;
        Pageable pageable = PageRequest.of(pageIndex,10, Sort.by("regDate"));
        Page<Member> entityPage = repository.findAll(pageable);
        Page<MemberDTO> dtoPage = entityPage.map(this::entityToDto);

        return dtoPage;
    }

    @Override
    public boolean register(MemberDTO dto) {
        String id = dto.getUserId();
        MemberDTO getDto = read(id);
        if (getDto != null) {
            System.out.println("사용 중인 아이디 입니다.");
            return false;
        }
        Member entity = dtoToEntity(dto);

        String enPw = passwordEncoder.encode(entity.getUserPw());
        entity.setUserPw(enPw);

        repository.save(entity);
        return true;
    }

    @Override
    public MemberDTO read(String id) {
        Optional<Member> result = repository.findById(id);
        if (result.isPresent()) {
            Member member = result.get();
            return entityToDto(member);
        } else {
            return null;
            }
    }

}
