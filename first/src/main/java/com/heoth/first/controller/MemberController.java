package com.heoth.first.controller;

import com.heoth.first.dto.Member;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MemberController {
    @GetMapping("/signin")
    public String signinForm(){
        return "member/signin";
    }
    @PostMapping("/signin")
        public String signin(Model model , @RequestParam("userID")String userID, @RequestParam("userPW")String userPW, @RequestParam("userName")String userName, @RequestParam(required = false)String userBirth){
        //service > repository
        log.info("userID={},userPW={},userName={}",userID,userPW,userName);
       List<String>member = new ArrayList<>();
       member.add(userID);
       member.add(userPW);
       member.add(userName);
       member.add("25");
       model.addAttribute("member",member);
        return "html/test";
        }
    @GetMapping("/list")
    public String list(Model model , @RequestParam("userID")String userID,@RequestParam("userPW")String userPW,@RequestParam("userName")String userName,@RequestParam("userAge")String userAge){
        model.addAttribute("userID",userID);
        model.addAttribute("userPW",userPW);
        model.addAttribute("userName",userName);
        model.addAttribute("userAge",userAge);
        return "member/list";
    }
}
