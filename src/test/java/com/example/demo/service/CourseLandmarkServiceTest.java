package com.example.demo.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.service.CourseLandmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseLandmarkServiceTest {

    @Autowired
    CourseLandmarkService service;

    @Test
    public void 등록테스트(){
        CourseLandmarkDTO dto = CourseLandmarkDTO.builder()
                .courseNo(0)
                .userId("11")
                .build();

        service.register(dto);

    }
}
