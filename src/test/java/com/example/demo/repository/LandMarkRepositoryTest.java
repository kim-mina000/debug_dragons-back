package com.example.demo.repository;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.repository.LandmarkRepository;
import com.example.demo.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.Optional;

@SpringBootTest
public class LandMarkRepositoryTest {

    @Autowired
    LandmarkRepository repository;

    @Test
    public void 저장해보기(){
        Landmark landmark = Landmark.builder()
                .landmarkAddress("냐냐냥")
                .landmarkName("냥뇽녕")
                .landmarkOrigin(1)
                .latitude("123")
                .longitude("123")
                .landmarkDay(10)
                .writer(Member.builder().userId("11").userPw("1234").userName("11").userRole("ROLE_USER").build())
                .landmarkTime(LocalTime.of(10,10,10))
                .build();

        repository.save(landmark);
    }

    @Test
    public void 수정하기(){
        Optional<Landmark> result = repository.findById(1);
        Landmark landmark = result.get();
        landmark.setLandmarkDay(10);
        landmark.setLandmarkTime(LocalTime.of(18,18));
        repository.save(landmark);
    }

    @Test
    public void 주소로랜드마크찾기(){
        Landmark landmark = repository.selectByAddress("대전 유성구 안산동 산 28-2").get();
        System.out.println(landmark);
    }
}
