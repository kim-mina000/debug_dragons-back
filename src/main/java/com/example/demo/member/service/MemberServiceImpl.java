package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

//@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

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
    @Transactional
    public String findPw(String userId, String userName, String userEmail) {
        String existingPw = repository.getPw(userId,userName,userEmail);
        if (existingPw == null){
            new IllegalAccessException("일치하는 회원이 없습니다.");
        }

//        임시비번생성
        String tempPw = generateTempPw();

//        임시비번 저장
        repository.updatePassword(userId,tempPw);

        return "임시 비밀번호가 이메일로 발송되었습니다.";
    }

    private String generateTempPw(){
        Random random = new Random();
        int length = 10;    //비밀번호 길이
        StringBuilder sb = new StringBuilder(length);
        for (int i =0; i<length; i++){
            char c = (char)(random.nextInt(26) + 'a');  //소문자 알파벳 랜덤생성
            sb.append(c);
        }
        return  sb.toString();
    }

    private void sendEmailsend(String to, String tempPw){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("임시 비밀번호 발송");
        message.setText("임시 비밀번호는 "+ tempPw + "입니다");
        mailSender.send(message);
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

}



