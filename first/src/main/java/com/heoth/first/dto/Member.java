package com.heoth.first.dto;

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
    private String userBirth;
    private String userName;
    private int userAge;

    public Member(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }
}
