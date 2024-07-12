package com.example.demo.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;



@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService service;

    @Test
    public void 회원등록() {
        MemberDTO dto = MemberDTO.builder()
                .userId("bbq5883")
                .userPw("1234")
                .userName("김참치")
                .userRole("ROLE_USER")
                .userEmail("kkkkkk@naver.com")
                .build();
        boolean isSuccess = service.register(dto);
        if(isSuccess) {
            System.out.println("회원 등록되었어요");
        }else {
            System.out.println("회원이 중복되었어요");
        }
    }

    @Test
    public void 회원목록조회() {
        Page<MemberDTO> page = service.getList(1);
        List<MemberDTO> list = page.getContent();
        for(MemberDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void 회원단건조회() {
        MemberDTO dto = service.read("user1");
        System.out.println(dto);
    }

    @Test
    public void 중복체크(){
        boolean yes = service.checkDuplicate("11");
        boolean no = service.checkDuplicate("abc");


        System.out.println(yes);
        System.out.println(no);
    }

}
