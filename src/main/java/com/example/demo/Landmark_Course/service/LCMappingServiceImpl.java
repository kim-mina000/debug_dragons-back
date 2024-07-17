package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.repository.LandmarkRepository;
import com.example.demo.Landmark.service.LandmarkService;
import com.example.demo.Landmark_Course.dto.LCMappingDTO;
import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.Landmark_Course.repository.LCMappingRepository;
import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.repository.CourseLandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LCMappingServiceImpl implements LCMappingService {

    @Autowired
    LCMappingRepository repository;

    @Autowired
    CourseLandmarkRepository courseLandmarkRepository;

    @Autowired
    LandmarkRepository landmarkRepository;

    @Override
    public int register(LCMappingDTO dto) {

        LCMapping entity = dtoToEntity(dto);
        repository.save(entity);
        int newNo = entity.getOrderNumber();

        return newNo;
    };

    @Override
    public List<LCMappingDTO> read(CourseLandmarkDTO courseNo) {

        CourseLandmark courseLandmark = courseLandmarkRepository.findById(courseNo.getCourseNo()).get();

        List<LCMapping> result = repository.findByCourseNo(courseLandmark);
        List<LCMappingDTO> dtoList = result.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public void changeLandmarkOriginShare(int landmarkNo) {
//      share하게 된다면  LCMapping 아니고 landmark의 origin숫자상태변경
        Optional<Landmark> result = landmarkRepository.findById(landmarkNo);
        if (result.isPresent()){
            result.get().setLandmarkOrigin(2);
        }
    }




}
