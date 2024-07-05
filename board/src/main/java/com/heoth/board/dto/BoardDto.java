package com.heoth.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {
    private int idx;
    @NotBlank(message="제목은 필수 입력사항입니다.")
    private String title;
    @NotBlank(message = "내용은 필수 입력사항입니다.")
    private String content;
    @NotBlank(message = "비밀번호는 필수 입력사항입니다.")
    private String password;
    private String regdate;
    @Builder
    public BoardDto(String title, String content,String password) {
        this.title = title;
        this.content = content;
        this.password=password;
    }
}
