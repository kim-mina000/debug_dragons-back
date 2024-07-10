package com.example.demo.Landmark.controller;

import com.example.demo.Landmark.dto.LandmarkDTO;
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
    public ResponseEntity<List<LandmarkDTO>> getList(@RequestParam(name="id")String userId){
//        List<LandmarkDTO> list = landmarkService.getList();
        List<LandmarkDTO> list = landmarkService.getListById(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/modifyLandmark")
    public ResponseEntity<Void> modifyLandmark(@RequestBody ArrayList<LandmarkDTO> list) {
        for (LandmarkDTO dto : list){
            LandmarkDTO baseDTO = landmarkService.read(dto.getLandmarkNo());

            baseDTO.setLandmarkDay(dto.getLandmarkDay());
            baseDTO.setLandmarkTime(dto.getLandmarkTime());
            baseDTO.setLandmarkShortDesc(dto.getLandmarkShortDesc());

            landmarkService.modify(baseDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/modifyLandmark")
    public ResponseEntity<Void> modifyLandmark(@RequestParam(name = "id") int landmarkNo) {
        landmarkService.remove(landmarkNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
