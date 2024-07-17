package com.example.demo.Landmark.controller;

import com.example.demo.Landmark.dto.LandmarkLikeDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.entity.LandmarkLike;
import com.example.demo.Landmark.repository.LandmarkLikeRepository;
import com.example.demo.Landmark.service.LandmarkLikeService;
import com.example.demo.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/landmarkLike")
public class LandmarkLikeController {

    @Autowired
    LandmarkLikeService landmarkLikeService;

    @PostMapping("/isLike")
    public ResponseEntity<String> toggleLike(@RequestBody LandmarkLikeDTO dto,
                                             Principal principal) {
//        String id =  principal.getName();   //인증된 ID가져오고

        Landmark landmark = new Landmark();
        landmark.setLandmarkNo(dto.getLandmarkNo());

        Member user = new Member();
//        user.setUserId(dto.getUserId());
        user.setUserId((principal.getName()));

        landmarkLikeService.toggleLike(landmark, user);
        return ResponseEntity.ok("islike");
    }

    @GetMapping("/list")
    public ResponseEntity<List<LandmarkLike>> getAllLikesByUser(@RequestParam String userId) {
        Member user = new Member();
        user.setUserId(userId);

        List<LandmarkLike> likes = landmarkLikeService.getAllLikesByUser(user);
        return ResponseEntity.ok(likes);
    }

    // 특정 랜드마크의 좋아요 수 조회
    // @PathVariable는 landmarkNo를 URL 경로에서 변수 값을 추출하여  파라미터로 받아와서 사용할수 있다
    @GetMapping("/likes/{landmarkNo}")
    public ResponseEntity<Integer> getLikesCount(@PathVariable int landmarkNo) {
        int likeCount = landmarkLikeService.likeCount(landmarkNo);
        return ResponseEntity.ok(likeCount);
    }

    @GetMapping("userLikeStatus")
    public ResponseEntity<LandmarkLike> getUserLikeStatus(@RequestParam("userId") String userId,
                                                          @RequestParam("isLike") boolean isLike) {
        Member member = new Member();
        member.setUserId(userId);

        LandmarkLike landmarkLike = landmarkLikeService.getUserLikeStatus(member, isLike);
        // landmarkLike이 null인 경우 클라이언트에게 404 에러를 반환;
        if (landmarkLike == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(landmarkLike, HttpStatus.OK);
    }
}