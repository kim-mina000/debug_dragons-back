package com.example.demo.Landmark.controller;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.service.LandmarkService;
import com.example.demo.Util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/landmark")
public class LandmarkController {

    @Autowired
    LandmarkService landmarkService;

    @Autowired
    FileUtil fileUtil;

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<LandmarkDTO> registerMyCourse(@RequestBody LandmarkDTO dto){
        LandmarkDTO landmarkDTO = landmarkService.register(dto);
        return new ResponseEntity<>(landmarkDTO, HttpStatus.OK);
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
    
    // 랜드마크No(PK값)으로 랜드마크 찾기
    @GetMapping("/readPK")
    public ResponseEntity<LandmarkDTO> readPK(@RequestParam(name = "landmarkNo") int landmarkNo){

        LandmarkDTO dto = landmarkService.findById(landmarkNo);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

// landmarkOrigin=2 인 값 가져오기
    @GetMapping("/lookaround")
    public ResponseEntity<List> readByOrigin2 (){
        List<LandmarkDTO> list = landmarkService.getListByOrigin(2);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    changeLandmarkOrigin은 LcController에서 쓰고있어요 register 부분
    @ResponseBody
    @PostMapping("/changeOrigin")
    public ResponseEntity<Void> changeOriginTo2(@RequestBody ArrayList<LandmarkDTO> list){

        for(LandmarkDTO dto : list){
            landmarkService.changeLandmarkOrigin2(dto.getLandmarkNo());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImg(@RequestParam("file") MultipartFile file,@RequestParam("no")int no ){

        LandmarkDTO landmarkDTO = landmarkService.read(no);
        String url = fileUtil.fileUpload(file);
        landmarkDTO.setLandmarkImgPath(url);

        landmarkService.register(landmarkDTO);


        return new ResponseEntity<>(url, HttpStatus.OK);
    }

}
