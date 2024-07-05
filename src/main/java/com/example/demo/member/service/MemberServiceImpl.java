package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

//@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    private JavaMailSender mailSender;

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

//        패스워드 인코더로 패스워드 암호화하기
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

    @Override
    public String findId(String userName, String userEmail) {
        return repository.getId(userName,userEmail);
    }

    @Override
    public boolean checkDuplicate(String id) {
        Optional<Member> result = repository.findById(id);
        if (result.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member updateMember(String id, Member newEntity) {
        Member member = repository.findById(id).orElse(null);

        if(member != null){
            member.setUserEmail(newEntity.getUserEmail());
            member.setUserName(newEntity.getUserName());
            member.setUserProfileImagePath(newEntity.getUserProfileImagePath());
//            member.setUserPw(newEntity.getUserPw()); 이건 나중에 패스워드도 수정할대 추가
            return repository.save(member);
        }
        return null;
    }

}



