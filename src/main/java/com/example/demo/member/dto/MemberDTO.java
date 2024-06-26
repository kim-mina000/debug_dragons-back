package com.example.demo.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MemberDTO {

    String user_id;

    String user_name;

    String user_pw;

    String user_profile_image_path;

    Boolean user_role;

    LocalDateTime regDate;
}
