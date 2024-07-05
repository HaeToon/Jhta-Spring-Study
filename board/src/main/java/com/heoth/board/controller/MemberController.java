package com.heoth.board.controller;

import com.heoth.board.dto.AlertDto;
import com.heoth.board.dto.LoginDto;
import com.heoth.board.dto.MemberDto;
import com.heoth.board.dto.ResultDto;
import com.heoth.board.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/signIn")
    public String signIn(Model model){
        model.addAttribute(new LoginDto());
        return "member/signIn";
    }
    @PostMapping("/signIn")
    public String signInProcess(@ModelAttribute LoginDto loginDto, RedirectAttributes redirectAttributes, HttpServletRequest request,Model model){
            AlertDto alertDto= null;
        int result = memberService.signIn(loginDto);
        if(result>0){
            alertDto=AlertDto.builder()
                    .title("성공.")
                    .text("로그인 되었습니다.")
                    .icon("success")
                    .build();
            MemberDto loginMember= memberService.loginInfo(loginDto);
            HttpSession session = request.getSession();
            session.setAttribute("userName",loginMember.getUserName());
            session.setAttribute("loginMember",loginMember);
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/";
        }else {
            alertDto=AlertDto.builder()
                    .title("실패.")
                    .text("로그인에 실패했습니다.")
                    .icon("error")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/member/signIn";
        }
    }
    @GetMapping("/info")
    public String info(HttpServletRequest request, Model model){
        HttpSession httpSession = request.getSession();
       MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginMember");
       model.addAttribute("memberDto",memberDto);
        return "member/info";
    }
@GetMapping("/logout")
public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
    AlertDto alertDto=AlertDto.builder()
            .title("로그아웃.")
            .text("로그아웃 되었습니다,.")
            .icon("success")
            .build();
    redirectAttributes.addFlashAttribute("alertDto",alertDto);
        return "redirect:/";
}
    @GetMapping("/signUp")
    public String signUp(){
        return "member/signUp";
    }
    @PostMapping("/signUp")
    public String signUpProcess(@Valid @ModelAttribute MemberDto memberDto, BindingResult bindingResult , RedirectAttributes redirectAttributes){
        AlertDto alertDto= null;
        if(bindingResult.hasErrors()){
            alertDto=AlertDto.builder()
                    .title("실패.")
                    .text("회원가입에 실패했습니다..")
                    .icon("error")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/member/signUp";
        }else{
            int duplacate = memberService.duplicateID(memberDto.getUserID());
            if(duplacate>0){
                alertDto=AlertDto.builder()
                        .title("실패.")
                        .text("중복된 아이디입니다..")
                        .icon("error")
                        .build();
                redirectAttributes.addFlashAttribute("alertDto",alertDto);
                return "redirect:/member/signUp";
            }
        }
        int result = memberService.signUp(memberDto);
        if(result>0){
            alertDto=AlertDto.builder()
                    .title("성공.")
                    .text("회원가입 되었습니다.")
                    .icon("success")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/";
        }else{
            alertDto=AlertDto.builder()
                    .title("실패.")
                    .text("회원가입에 실패했습니다..")
                    .icon("error")
                    .build();
            redirectAttributes.addFlashAttribute("alertDto",alertDto);
            return "redirect:/member/signUp";
        }
    }
    @PostMapping("/duplicate-id")
    @ResponseBody
    public ResponseEntity<Object> duplicatate(@RequestParam String userID){
        log.info("userID==={}",userID);
        int result = memberService.duplicateID(userID);
        log.info("result==={}",result);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("status","fail");
        }else{
            map.put("status","ok");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        return ResponseEntity.ok(map);
//        return new ResponseEntity<>(map,HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.OK);
//        return new ResponseEntity<>(map,httpHeaders,HttpStatus.OK);
//        ResultDto resultDto = ResultDto.builder()
//                .httpstatus(HttpStatus.OK)
//                .resultData(map)
//                .message("성공")
//                .build();
//
//        return new ResponseEntity<>(resultDto,HttpStatus.OK);
    }
}
