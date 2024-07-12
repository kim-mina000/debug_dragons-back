package com.example.demo.Landmark.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.Landmark.repository.LandmarkLikeRepository;
import com.example.demo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandmarkLikeServiceImpl implements LandmarkLikeService {

    @Autowired
    LandmarkLikeRepository landmarkLikeRepository;

    @Override
    public void toggleLike(Landmark landmark, Member userId) {
        Optional<LandmarkLike> toggleLike = landmarkLikeRepository.findByLandmarkNoAndUserId(landmark, userId);
//        좋아요 있다면?
        if (toggleLike.isPresent()){
            landmarkLikeRepository.delete(toggleLike.get());
        }else{
//            좋아요 없으면
            LandmarkLike addLike = LandmarkLike.builder()
                    .landmarkNo(landmark)
                    .userId(userId)
                    .isLike(true)
                    .build();
            landmarkLikeRepository.save(addLike);
        }

    }

    @Override
    public List<LandmarkLike> getAllLikesByUser(Member userId) {
        return landmarkLikeRepository.findByUserId(userId);
    }
}
