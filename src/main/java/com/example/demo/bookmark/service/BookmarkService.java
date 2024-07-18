package com.example.demo.bookmark.service;

import com.example.demo.Landmark.entity.Landmark;
import com.example.demo.bookmark.dto.BookmarkDTO;
import com.example.demo.bookmark.entity.Bookmark;
import com.example.demo.member.entity.Member;

import java.util.List;

public interface BookmarkService {

//    등록
    void register(BookmarkDTO dto);

//    삭제
    void remove(int bookmarkNo);

//    조회
    List<BookmarkDTO> read(String id);


    default Bookmark dtoToEntity(BookmarkDTO dto){

        Member member = Member.builder().userId(dto.getMember()).build();
        Landmark landmark = Landmark.builder().landmarkNo(dto.getLandmark()).build();

        Bookmark entity = Bookmark.builder()
                .bookmarkNo(dto.getBookmarkNo())
                .landmark(landmark)
                .member(member)
                .build();

        return entity;

    }

    default BookmarkDTO entityTodto(Bookmark entity){

        BookmarkDTO dto = BookmarkDTO.builder()
                .member(entity.getMember().getUserId())
                .landmark(entity.getLandmark().getLandmarkNo())
                .bookmarkNo(entity.getBookmarkNo())
                .build();

        return dto;

    }
}
