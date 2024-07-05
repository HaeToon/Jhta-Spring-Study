package com.heoth.ch01.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private int idx;
    @NotBlank(message = "이름은 필수 입력사항입니다.")
    private String userName;
    @NotBlank(message = "아이디는 필수 입력사항입니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 입력사항입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String userPw;
    @NotBlank(message = "이메일은 필수 입력사항입니다.")
    @Email
    private String userEmail;

    @Builder
    public Member (String userId,String userPw,String userName,String userEmail){
        this.userId=userId;
        this.userPw=userPw;
        this.userName=userName;
        this.userEmail=userEmail;
    }
}
