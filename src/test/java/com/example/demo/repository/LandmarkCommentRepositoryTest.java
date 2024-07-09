package com.example.demo.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkComment;
import com.example.demo.Landmark.repository.LandmarkCommentRepository;
import com.example.demo.Landmark.repository.LandmarkRepository;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class LandmarkCommentRepositoryTest {

    @Autowired
    LandmarkCommentRepository repository;

    @Test
    public void 댓글등록(){
//        멤버(사용자)생성
        Member member = Member.builder()
                .userId("green")
                .build();

//        랜드마크게시글 생성
        Landmark landmark = Landmark.builder()
                .landmarkNo(1)
                .build();

//        **댓글생성**
        LandmarkComment comment = LandmarkComment.builder()
                .landmarkNo(landmark)
                .writer(member)
                .landmarkCommentContent("댓글 달았어요")
                .build();
        repository.save(comment);   //  db저장해
    }

    @Test
    public void 댓글목록조회() {
        List<LandmarkComment> list = repository.findAll();
        for(LandmarkComment comment : list) {
            System.out.println(comment);
        }
    }

    @Test
    public void 댓글단건조회() {
        Optional<LandmarkComment> result = repository.findById(1);
//        ?결과없음?
        if(result.isPresent()) {
            LandmarkComment comment = result.get();
            System.out.println(comment);
        }
    }

    @Test
    public void 댓글수정() {
        // 기존 댓글 조회
        Optional<LandmarkComment> result = repository.findById(1);
        LandmarkComment comment = result.get();
        // 일부 내용 변경
        comment.setLandmarkCommentContent("댓글내용수정수정수정");
        // 댓글 수정
        repository.save(comment);
    }

    @Test
    public void 댓글삭제() {
        repository.deleteById(1);
    }

    @Test
    public void 게시물별_댓글조회(){
        Landmark landmark = Landmark.builder().landmarkNo(1).build();
        List<LandmarkComment> list = repository.findByLandmarkNo(landmark);
        for (LandmarkComment comment : list){
            System.out.println(comment);
        }
    }

    @Test
    public  void 게시물별_댓글삭제(){
        Landmark landmark = Landmark.builder().landmarkNo(2).build();
        repository.deleteByLandmarkNo(landmark);
    }

}
