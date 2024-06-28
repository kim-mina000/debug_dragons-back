package com.example.demo.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void 회원등록(){
        Member member = Member.builder()
                .userId("choi")
                .userPw("1234")
                .userName("최개발")
                .userRole(false)
                .build();

        repository.save(member);
    }

    @Test
    public void 회원목록조회(){
        List<Member> list =  repository.findAll();
        for(Member member: list){
            System.out.println(member);
        }
    }

    @Test
    public void 회원1건조회(){
        Optional<Member> result = repository.findById("11");
        if (result.isPresent()){
            Member member = result.get();
            System.out.println(member);
        }
    }

    @Test
    public void 회원수정(){
        Optional<Member> result = repository.findById("park");
        if (result.isPresent()) {
            Member member = result.get();
            member.setUserName("박자바");
            repository.save(member);
        }
    }

    @Test
    public void 회원삭제(){
        repository.deleteById("choi");
    }

//    @Test
//    public void 관계설정_회원삭제(){
//        Member member = Member.builder().user_id("park").build();
//        여행게시물리파지토리.delete글쓰이(writer = user_id)(member);
//          repository.deleteById("park");
//    }
//    여행or코스(?)게시물완성후 테스트요망 게시물없는회원,
//    게시물 있는회원은 게시물 삭제 후 회원삭제
//    만약 게시물 있어도 삭제 가능캐하려면 필요없을지도.
}
