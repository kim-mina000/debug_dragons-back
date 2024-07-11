package com.example.demo.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.dto.MemberTagDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.service.MemberTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberTagServiceTest {

    @Autowired
    MemberTagService service;

    @Test
    public void 태그등록(){
        MemberTagDTO dto = MemberTagDTO.builder()
                .memberTag("시리야..자니?")
                .userId("11")
                .build();
        service.register(dto);
    }

    @Test
    public void 아이디로태그조회(){
        List<MemberTagDTO> list = service.getList("11");
        for (MemberTagDTO dto : list){
            System.out.println(dto);
        }
    }

    @Test
    public void 태그목록삭제(){
        service.removeAll("123");
    }


}
