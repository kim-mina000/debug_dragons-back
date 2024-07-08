package com.example.demo.Landmark.service;

import com.example.demo.Landmark.dto.LandmarkDTO;
import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.Landmark.repository.LandmarkRepository;
import com.example.demo.Util.FileUtil;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service    // 서비스 클래스로 지정
public class LandmarkServiceImpl implements LandmarkService {
    @Autowired
    LandmarkRepository repository;  // 사용할 리파지토리를 멤버로 선언

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private FileUtil fileUtil;

    //  상속받은 메소드 구현(랜드마크등록~삭제)
    @Override
    public int register(LandmarkDTO dto) {
        Landmark entity = dtoToEntity(dto); // 파라미터로 전달받은 dto를 엔티티로 변환

        // 유틸클래스를 이용해서 파일을 폴더에 저장하고 파일이름을 반환받는다
//        String imgPath = fileUtil.fileUpload(dto.getUploadFile());
//        // 그리고 엔티티에 파일이름을 저장한다
//        entity.setLandmarkImgPath(imgPath);

        repository.save(entity); // 리파지토리로 게시물 등록
        int newNo = entity.getLandmarkNo();

        return newNo; // 새로운 게시물의 번호 반환
    }

    @Override
    public List<LandmarkDTO> getList() {
        List<Landmark> result = repository.findAll();   // 데이터베이스에서 게시물 목록을 가져온다
        List<LandmarkDTO> list = new ArrayList<>();
        list = result.stream()                          // 리스트에서 스트림 생성
                .map(entity -> entityToDto(entity))     // 중간연산으로 엔티티를 dto로 변환
                .collect(Collectors.toList());          // 최종연산으로 결과를 리스트로 변환

        return list;
    }

    @Override
    public LandmarkDTO read(int no) {
        Optional<Landmark> result = repository.findById(no);

        if (result.isPresent()) {
            Landmark landmark = result.get();
            LandmarkDTO landmarkDTO = entityToDto(landmark);    //엔티티 -> 디티오변환
            return landmarkDTO;
        } else {
            return null;
        }
    }

    @Override
    public void modify(LandmarkDTO dto) {
        // 업데이트 항목: 제목, 소개글, 간단소개글, 주소, 전화번호, 경도, 위도, 사진파일경로

        // 전달받은 DTO에서 게시물 번호 꺼내고, 해당 게시물 조회
        Optional<Landmark> result = repository.findById(dto.getLandmarkNo());
        if (result.isPresent()) { // 해당 게시물이 존재하는지 확인
            Landmark entity = result.get();

            // 기존 엔티티에서 제목과 내용만 변경
            entity.setLandmarkName(dto.getLandmarkName());
            entity.setLandmarkDesc(dto.getLandmarkDesc());
            entity.setLandmarkShortDesc(dto.getLandmarkShortDesc());
            entity.setLandmarkAddress(dto.getLandmarkAddress());
            entity.setLandmarkPhone(dto.getLandmarkPhone());
            entity.setLongitude(dto.getLongitude());
            entity.setLatitude(dto.getLatitude());
            entity.setLandmarkImgPath(dto.getLandmarkImgPath());
            entity.setLandmarkTime(dto.getLandmarkTime());
            entity.setLandmarkDay(dto.getLandmarkDay());

            // 다시 저장
            repository.save(entity);
        }

    }

    @Override
    public int remove(int no) {
        Optional<Landmark> result = repository.findById(no);

        if (result.isPresent()) {
            repository.deleteById(no);
            return 1; // 성공
        } else {
            return 0; // 실패
        }
    }

    @Override
    public void saveLandmarkWithWriter(Landmark landmark, Member writer) {
        writer = memberRepository.save(writer); // Member 엔티티 먼저 저장
        landmark.setWriter(writer); // Landmark 엔티티에 연관 엔티티 설정
        repository.save(landmark); // Landmark 엔티티 저장
    }

}


