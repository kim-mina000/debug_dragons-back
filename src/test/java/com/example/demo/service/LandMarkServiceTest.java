package com.example.demo.service;

import com.example.demo.Landmark.service.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandMarkServiceTest {

    @Autowired
    LandmarkService service;

//    @Test
//    public void 서비스(){
//        LandmarkDTO dto = LandmarkDTO.builder()
//                .landmarkNo(0)
//                .landmarkAddress("냥뇬녕")
//                .landmarkName("냐냐")
//                .landmarkOrigin(true)
//                .longitude("123")
//                .latitude("123")
//                .build();
//
//        int no = service.register(dto);
//
//        System.out.println("새로 입력된 게시물 넘버" + no);
//
//    }
}
