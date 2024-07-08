package com.example.demo.service;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.service.LandmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
public class LandMarkServiceTest {

    @Autowired
    LandmarkService service;

    @Test
    public void 서비스(){
        LandmarkDTO dto = LandmarkDTO.builder()
                .landmarkNo(0)
                .writer("bbq5883")
                .landmarkDay(2)
                .landmarkTime(LocalTime.of(20,30))
                .landmarkAddress("서울")
                .landmarkName("숭례문")
                .landmarkOrigin(true)
                .landmarkShortDesc("국보1호 태우지마")
                .landmarkDesc("국보1호입니다 서울 한복판에 있어요")
                .longitude("123")
                .latitude("123")
                .build();

        int no = service.register(dto);

        System.out.println("새로 입력된 게시물 넘버" + no);

    }

    @Test
    public void 리스트줘(){
        List list = service.getList();
        System.out.println(list);
    }

    @Test
    public void 수정해죠(){
        LandmarkDTO landmark = LandmarkDTO.builder()
                .landmarkNo(1)
                .landmarkDay(9 )
                .landmarkTime(LocalTime.of(9,10,10))
                .writer("11")
                .landmarkAddress("시리네집")
                .landmarkName("호엥")
                .longitude("123456")
                .latitude("1231455")
                .landmarkOrigin(true)
                .build();

        service.register(landmark);
    }

}
