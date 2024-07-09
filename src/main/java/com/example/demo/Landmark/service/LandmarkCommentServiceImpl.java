package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkCommentDTO;
import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkComment;
import com.example.demo.Landmark.repository.LandmarkCommentRepository;
import com.example.demo.Landmark.repository.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LandmarkCommentServiceImpl implements LandmarkCommentService {

    @Autowired
    private LandmarkCommentRepository repository;

//    게시물기준, 댓글목록조회
    @Override
    public List<LandmarkCommentDTO> getListByLandmarkNo(int landmarkNo) {
        Landmark landmark = Landmark.builder().landmarkNo(landmarkNo).build();
        List<LandmarkComment> entityList = repository.findByLandmarkNo(landmark);
        List<LandmarkCommentDTO> dtoList = new ArrayList<>();
        for (LandmarkComment entity : entityList){
            LandmarkCommentDTO dto = entityToDto(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

//    댓글등록
    @Override
    public int register(LandmarkCommentDTO dto) {
        LandmarkComment entity = dtoToEntity(dto);
        repository.save(entity);

        return entity.getLandmarkCommentNo();
    }

//   게시물 삭제
    @Override
    public boolean remove(int no) {
        Optional<LandmarkComment> comment = repository.findById(no);
//        해당댓글있는지 확인 후 ↑  ↓ 없다면 false반환
        if (comment.isEmpty()){
            return false;
        }
//        해당댓글 있으면 삭제 후 true 반환해
        repository.deleteById(no);
        return true;
    }
}
