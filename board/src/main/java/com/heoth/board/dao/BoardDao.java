package com.heoth.board.dao;

import com.heoth.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    int writeBoard(BoardDto boardDto);
    List<BoardDto> boardList();
    BoardDto viewBoardDto(int idx);
    int deleteBoard(BoardDto boardDto);
}
