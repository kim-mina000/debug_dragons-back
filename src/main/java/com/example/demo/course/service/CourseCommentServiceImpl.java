package com.example.demo.course.service;

import com.example.demo.course.dto.CourseCommentDTO;
import com.example.demo.course.dto.CourseLandmarkDTO;
import com.example.demo.course.entity.CourseComment;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.repository.CourseCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseCommentServiceImpl implements CourseCommentService {

    @Autowired
    private CourseCommentRepository repository;


//    코스게시물 기준, 댓글목록조회
    @Override
    public List<CourseCommentDTO> getListByComment(String courseNo) {
        CourseLandmark courseLandmark = CourseLandmark.builder().courseNo(courseNo).build();
        List<CourseComment> entityList = repository.findByCourseNo(courseLandmark);
        List<CourseCommentDTO> dtoList = new ArrayList<>();
        for (CourseComment entity : entityList){
            CourseCommentDTO dto = entityTodto(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

//    댓글등록
    @Override
    public int register(CourseCommentDTO dto) {
        CourseComment entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getCourseCommentNo();
    }

//    게시물삭제
    @Override
    public boolean remove(int courseLandmarkNo) {
        Optional<CourseComment> comment = repository.findById(courseLandmarkNo);
        if (comment.isPresent()){
            return false;
        }
        repository.deleteById(courseLandmarkNo);
        return true;
    }

}
