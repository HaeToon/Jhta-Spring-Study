package com.heoth.board.controller;

import com.heoth.board.dto.LoginDto;
import com.heoth.board.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

//annotation @Component,@Controller,@Service등 사용시 bean 등록
//spring의 scan(component scan)
@Controller //bean으로 등록
@Slf4j
public class IndexController {

    @GetMapping({"/index","/welcome","/"})
    public String index(HttpServletRequest request, Model model){
        HttpSession httpSession = request.getSession();
        MemberDto loginMemberInfo = (MemberDto) httpSession.getAttribute("loginMember");
        model.addAttribute("loginMemberInfo",loginMemberInfo);
        log.info("loginMemberInfo=={}",loginMemberInfo);
//        log.info("sessionLoginDto=={}",loginDto);
        return "index/index";
    }

}
