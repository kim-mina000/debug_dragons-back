package com.example.demo.service;

import com.example.demo.bookmark.dto.BookmarkDTO;
import com.example.demo.bookmark.service.BookmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookmarkServiceTest {

    @Autowired
    BookmarkService service;

    @Test
    public void 등록(){
        BookmarkDTO dto = BookmarkDTO.builder()
                .bookmarkNo(0)
                .member("11")
                .landmark(10)
                .build();

        service.register(dto);

    };

    @Test
    public void 조회(){
        List<BookmarkDTO> list = service.read("11");
        for (BookmarkDTO dtp : list) {
            System.out.println(dtp);
        }
    }

    @Test
    public void 삭제(){
        service.remove(4);
    }
}
