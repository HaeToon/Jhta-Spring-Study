package com.heoth.board.controller;

import com.heoth.board.dto.AlertDto;
import com.heoth.board.dto.BoardDto;
import com.heoth.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping
    public String board(Model model) {
       List<BoardDto> boardList = boardService.boardList();
       model.addAttribute("boardList",boardList);
        return "board/board";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("boardDto", new BoardDto());
        return "board/board-write";
    }

    @PostMapping("/write")
    public String writeProcess(@Valid @ModelAttribute BoardDto boardDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            @ModelAttribute 를 쓰면 자동으로 넘어온 값을 갖고 forward시켜줌.
            return "board/board-write";
        }
        boardService.writeBoard(boardDto);
        return "redirect:/board";
    }
    @GetMapping("/view/{idx}")
    public String viewBoard(@PathVariable int idx, Model model){
        BoardDto viewBoardDto = boardService.viewBoardDto(idx);
        model.addAttribute("viewBoardDto",viewBoardDto);
        return "board/view";
    }
//    @GetMapping("/delete/{idx}")
    public String deleteBoard(@PathVariable int idx , Model model){
        BoardDto deleteBoardDto = boardService.viewBoardDto(idx);
        model.addAttribute("deleteBoardDto",deleteBoardDto);
        return"board/delete";
    }
    @GetMapping("/delete/{idx}")
    public String deleteBoard(@PathVariable int idx){
        return"board/delete";
    }
//    @GetMapping("/delete")
    public String deleteBoard(){
        return"board/delete";
    }
    @GetMapping("/delete")
    public String deleteBoardParam(){
        return"board/delete-param";
    }
    @PostMapping("/delete")
    public String deleteBoardProcess(@ModelAttribute BoardDto deleteBoardDto, RedirectAttributes redirectAttributes){

        int result = boardService.deleteBoard(deleteBoardDto);
        AlertDto alertDto = null;
        if(result!=1){
            alertDto = AlertDto.builder()
                    .title("Fail")
                    .text("삭제에 실패했습니다..")
                    .icon("error")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/board/delete/"+deleteBoardDto.getIdx();
        }else{
             alertDto = AlertDto.builder()
                    .title("OK")
                    .text("삭제되었습니다.")
                    .icon("success")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/board";
        }
    }
}
