package com.example.demo.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.service.CourseLandmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseLandmarkServiceTest {

    @Autowired
    CourseLandmarkService service;

//    @Test
//    public void 등록테스트(){
//        CourseLandmarkDTO dto = CourseLandmarkDTO.builder()
//                .courseNo(0)
//                .userId("11")
//                .build();
//
//        service.register(dto);
//
//    }

    @Test
    public void 리스트검색(){

        List<CourseLandmarkDTO> list = service.readByUserId("11");
        for (CourseLandmarkDTO dto : list){
            System.out.println(dto);
        }
//        여기까지 완료했음 이제 컨트롤러에서 구현하면 됨!
    }
}
