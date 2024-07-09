package com.example.demo.service;

import com.example.demo.Landmark.dto.LandmarkCommentDTO;
import com.example.demo.Landmark.service.LandmarkCommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LandmarkCommentServiceTest {

    @Autowired
    LandmarkCommentService service;

    @Test
    public void 댓글등록(){
        LandmarkCommentDTO dto = LandmarkCommentDTO.builder()
                .landmarkCommentContent("저도댓글달아요")
                .landmarkNo(5)
                .writer("bbq5883")
                .build();
        service.register(dto);

    }

    @Test
    public void 게시물별댓글조회(){
        List<LandmarkCommentDTO> list = service.getListByLandmarkNo(5);
        for (LandmarkCommentDTO dto : list){
            System.out.println(dto);
        }
    }

    @Test
    public void 댓글삭제(){
        service.remove(2);
    }


}
