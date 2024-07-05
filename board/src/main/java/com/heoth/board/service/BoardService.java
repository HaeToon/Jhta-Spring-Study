package com.heoth.board.service;

import com.heoth.board.dao.BoardDao;
import com.heoth.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardDao boardDao;
    public int writeBoard(BoardDto boardDto){
        return boardDao.writeBoard(boardDto);
    }
    public List<BoardDto> boardList(){
        return boardDao.boardList();
    }
    public BoardDto viewBoardDto (int idx){
        return boardDao.viewBoardDto(idx);
    }
    public int deleteBoard(BoardDto boardDto){
        return boardDao.deleteBoard(boardDto);
    }
}
