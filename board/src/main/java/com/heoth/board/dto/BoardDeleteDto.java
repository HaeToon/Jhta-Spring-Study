package com.heoth.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDeleteDto {
    private int idx;
    private String password;
}
