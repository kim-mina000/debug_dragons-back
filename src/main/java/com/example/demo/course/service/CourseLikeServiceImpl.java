package com.example.demo.course.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.course.entity.CourseLandmark;
import com.example.demo.course.entity.CourseLike;
import com.example.demo.course.repository.CourseLikeRepository;
import com.example.demo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseLikeServiceImpl implements CourseLikeService {

    @Autowired
    CourseLikeRepository courseLikeRepository;

    @Override
    public void toggleLikeCourse(CourseLandmark courseLandmark, Member userId) {

        Optional<CourseLike> toggleLikeCourse = courseLikeRepository.findByCourseNoAndUserId(courseLandmark, userId);
        if(toggleLikeCourse.isPresent()){
            CourseLike existingLike = toggleLikeCourse.get();
            existingLike.setLike(!existingLike.isLike());
            courseLikeRepository.save(existingLike);
        }else{
            CourseLike addCourseLike = CourseLike.builder()
                    .courseNo(courseLandmark)
                    .userId(userId)
                    .isLike(true)
                    .build();
            courseLikeRepository.save(addCourseLike);
        }
    }

    @Override
    public List<CourseLike> getAllLikesByUser(Member userId) {
        return courseLikeRepository.findByUserId(userId);
    }


}
