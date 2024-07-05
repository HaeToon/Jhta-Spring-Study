package com.heoth.practice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "아이디는 반드시 입력해야합니다.")
    private String userID;
    @NotBlank(message = "비밀번호는 반드시 입력해야합니다.")
    private String userPW;
    @NotBlank(message = "이름은 반드시 입력해야합니다.")
    private String userName;
    @NotBlank(message = "이메일은 반드시 입력해야합니다.")
    @Email
    private String userEmail;
}
