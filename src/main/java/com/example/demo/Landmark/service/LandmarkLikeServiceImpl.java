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
//      ↓ 2)좋아요가 존재한다면,        ↑ 1)특정랜드마크게시판, 사용자에 대해 좋아요 있는지 확인후
        if (toggleLike.isPresent()){
            LandmarkLike existingLike = toggleLike.get();
            existingLike.setLike(!existingLike.isLike());
            landmarkLikeRepository.save(existingLike);
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

    @Override
    public int likeCount(int landmark) {
        return landmarkLikeRepository.countIsLikeTrue(landmark);
    }

    @Override
    public LandmarkLike getUserLikeStatus(Member userId, boolean isLike) {
        return landmarkLikeRepository.findByUserIdAndIsLike(userId, isLike);
    }

}
