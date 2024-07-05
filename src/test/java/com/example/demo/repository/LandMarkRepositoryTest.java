package com.example.demo.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.repository.LandmarkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandMarkRepositoryTest {

    @Autowired
    LandmarkRepository repository;

    @Test
    public void 저장해보기(){
        Landmark landmark = Landmark.builder()
                .landmarkAddress("냐냐냥")
                .landmarkName("냥뇽녕")
                .landmarkOrigin(true)
                .latitude("123")
                .longitude("123")
                .build();

        repository.save(landmark);
    }
}
