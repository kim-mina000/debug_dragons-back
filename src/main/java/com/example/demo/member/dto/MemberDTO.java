package com.example.demo.member.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MemberDTO {

    String userId;

    String userName;

    String userPw;

    String userProfileImagePath;

    String userRole;

    LocalDateTime regDate;

    String userEmail;

<<<<<<< HEAD
    String nickname;
=======
    String phone;

    LocalDate birth;


>>>>>>> 0c3cbcc00d4f279559c7a5d008151e61719c7121
}
