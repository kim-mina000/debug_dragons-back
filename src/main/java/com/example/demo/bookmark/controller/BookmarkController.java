package com.example.demo.bookmark.controller;

import com.example.demo.bookmark.dto.BookmarkDTO;
import com.example.demo.bookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    BookmarkService service;

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody BookmarkDTO dto){
        service.register(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam(name = "no")int no){
        service.remove(no);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List> read(@RequestParam(name = "id")String id){
        List<BookmarkDTO> list = service.read(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/toggle")
    public ResponseEntity<Void> toggle(@RequestParam(name = "id") String id,
                                       @RequestParam(name = "no") int no ){
        List<BookmarkDTO> list = service.read(id);
        boolean hasValue = false;

        for (BookmarkDTO dto : list){
            if(dto.getBookmarkNo() == no){
                service.remove(no);
                hasValue = true;
            }
        }

        if (hasValue){
            BookmarkDTO dto = BookmarkDTO.builder().bookmarkNo(0).landmark(no).member(id).build();
            service.register(dto);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/readByNo")
    public ResponseEntity<List> readAllByNo(@RequestParam(name = "no") int no){
        List<BookmarkDTO> list = service.readAllByNo(no);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
