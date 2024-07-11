package com.example.demo.repository;

import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.Landmark_Course.repository.LCMappingRepository;
import com.example.demo.course.entity.CourseLandmark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LCMappingRepositoryTest {

    @Autowired
    LCMappingRepository repository;

    @Test
    public void 코스넘버로찾기(){

        CourseLandmark courseLandmark = CourseLandmark.builder().courseNo("5fe93278-c").build();

        List<LCMapping> list = repository.findByCourseNo(courseLandmark);
        for (LCMapping dto : list) {
            System.out.println(dto);
        }

    }

}
