package com.heoth.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private int idx;
    @NotBlank(message = "아이디는 필수 입력사항 입니다.")
    private String userID;
    @NotBlank(message = "비밀번호 필수 입력사항 입니다.")
    private String userPW;
    @NotBlank(message = "이름은 필수 입력사항 입니다.")
    private String userName;
    @NotBlank(message = "이메일은 필수 입력사항 입니다.")
    private String userEmail;
    @Builder
    public MemberDto(String userID, String userPW, String userName, String userEmail) {
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
