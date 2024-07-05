package com.heoth.board.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResultDto {
    private HttpStatus httpstatus;
    private String message;
    private Object resultData;
}
