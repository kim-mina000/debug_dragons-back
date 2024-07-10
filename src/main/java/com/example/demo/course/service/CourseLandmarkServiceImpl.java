package com.example.demo.course.service;

import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.repository.CourseLandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseLandmarkServiceImpl implements CourseLandmarkService {

    @Autowired
    CourseLandmarkRepository repository;

    @Override
    public void register(CourseLandmarkDTO dto) {
        CourseLandmark entity = dtoToEntity(dto);

        repository.save(entity);
    }

    @Override
    public List<CourseLandmarkDTO> readByUserId(String userId) {

        List<CourseLandmark> result = repository.readByUserId(userId);
        List<CourseLandmarkDTO> courseLandmarkDTO = result.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());

        return courseLandmarkDTO;
    }
}
