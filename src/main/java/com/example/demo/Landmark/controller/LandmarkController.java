package com.example.demo.Landmark.controller;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.repository.LandmarkRepository;
import com.example.demo.Landmark.service.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/landmark")
public class LandmarkController {

    @Autowired
    LandmarkService landmarkService;

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<Integer> registerMyCourse(@RequestBody LandmarkDTO dto){
        int no =landmarkService.register(dto);
        System.out.println(no);
        return new ResponseEntity<>(no, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<LandmarkDTO>> getList(){
        List<LandmarkDTO> list = landmarkService.getList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/modifyLandmark")
    public ResponseEntity<Void> modifyLandmark(@RequestBody ArrayList<LandmarkDTO> list) {
//        System.out.println(list);
//        ArrayList<Landmark> landmarks = new ArrayList<>();
//        for (LandmarkDTO dto : list) {
//            System.out.println(dto);
//            Landmark landmark = new Landmark();
//           landmark.setLandmarkNo(dto.getLandmarkNo());
//           if (dto.getLandmarkDay() != 0){
//               landmark.setLandmarkDay(dto.getLandmarkDay());
//           }
//           if (dto.getLandmarkTime() != null){
//               landmark.setLandmarkTime(dto.getLandmarkTime());
//           }
//           landmarks.add(landmark);
//        }
//        landmarkRepository.saveAll(landmarks);
//        return ResponseEntity.ok().build();

        for (LandmarkDTO dto : list){
            System.out.println("받아온값" + dto);
            LandmarkDTO baseDTO = landmarkService.read(dto.getLandmarkNo());

            baseDTO.setLandmarkDay(dto.getLandmarkDay());
            baseDTO.setLandmarkTime(dto.getLandmarkTime());
            baseDTO.setLandmarkShortDesc(dto.getLandmarkShortDesc());

            landmarkService.modify(baseDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
