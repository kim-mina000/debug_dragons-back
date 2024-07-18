package com.example.demo.bookmark.service;

import com.example.demo.bookmark.dto.BookmarkDTO;
import com.example.demo.bookmark.entity.Bookmark;
import com.example.demo.bookmark.repository.BookmarkRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository repository;


    @Override
    public void register(BookmarkDTO dto) {
        Bookmark entity = dtoToEntity(dto);
        repository.save(entity);
    }

    @Override
    public void remove(int bookmarkNo) {
        repository.deleteById(bookmarkNo);
    }

    @Override
    public List<BookmarkDTO> read(String id) {

        Member member = Member.builder().userId(id).build();

        List<BookmarkDTO> list = repository.findByUserId(member).stream()
                .map(entity -> entityTodto(entity))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<BookmarkDTO>  readAllByNo(int no) {
        List<Bookmark> result = repository.findAllById(no);
        if(!result.isEmpty()){
            List<BookmarkDTO> list = result.stream()
                    .map(entity -> entityTodto(entity))
                    .collect(Collectors.toList());
            return list;
        }
        return null;
    }
}
