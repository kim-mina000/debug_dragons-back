package com.example.demo.Landmark_Course.service;

import com.example.demo.Landmark_Course.dto.LCMappingDTO;
import com.example.demo.Landmark_Course.entity.LCMapping;
import com.example.demo.Landmark_Course.repository.LCMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LCMappingServiceImpl implements LCMappingService {

    @Autowired
    LCMappingRepository repository;

    @Override
    public int register(LCMappingDTO dto) {

        LCMapping entity = dtoToEntity(dto);
        repository.save(entity);
        int newNo = entity.getOrderNumber();

        return newNo;
    }
}
