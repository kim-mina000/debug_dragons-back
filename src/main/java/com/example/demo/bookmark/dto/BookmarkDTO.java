package com.example.demo.bookmark.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarkDTO {

    int bookmarkNo;

    String member;

    int landmark;


}
