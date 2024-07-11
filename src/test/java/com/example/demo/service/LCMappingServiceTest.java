package com.example.demo.service;

import com.example.demo.Landmark_Course.service.LCMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LCMappingServiceTest {

    @Autowired
    LCMappingService service;

//    @Test
//    public void 등록(){
//
//        LCMappingDTO dto = LCMappingDTO.builder()
//                .isSave(false)
//                .orderNumber(0)
//                .courseNo(1)
//                .landmarkNo(3)
//                .build();
//
//        service.register(dto);
//
//    };

}
