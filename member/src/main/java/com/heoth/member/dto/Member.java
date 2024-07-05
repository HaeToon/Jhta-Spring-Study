package com.heoth.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
    private String userID;
    private String userPW;
    private String userName;
    private String userBirth;
    private int age;
    private int Idx;
}
