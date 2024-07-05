package com.heoth.ch01.controller;

import com.heoth.ch01.dto.Member;
import com.heoth.ch01.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String list(Model model) {
        ArrayList<Member> members = (ArrayList<Member>) memberService.findAllMember();
        model.addAttribute("members", members);
        return "member/members";
    }

    @GetMapping("/info/{idx}")
    public String info(@PathVariable int idx,Model model) {

        Member infoMember = memberService.findMember(idx).get();
        model.addAttribute("infoMember",infoMember);
        model.addAttribute("status",true);
        return "member/info";
    }
//    @GetMapping("/signin")
    public String signin(Model model) {
        //"/templates/"+ member/signin+".html"
        model.addAttribute("paramMember",new Member());
        return "member/signin02";
    }
    @GetMapping("/signin")
    public String signin03(Model model) {
        //"/templates/"+ member/signin+".html"
        model.addAttribute("member",new Member());
        return "member/signin03";
    }

    //@PostMapping("/signin")
    public String signinProcess(@RequestParam String userId,
                                @RequestParam String userName,
                                @RequestParam String userPw) {
//        Member paramMember = new Member();
//        paramMember.setUserId(userId);
//        paramMember.setUserName(userName);
//        paramMember.setUserPw(userPw);
        Member paramMember = Member.builder()
                .userId(userId)
                .userName(userName)
                .userPw(userPw)
                .build();
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
//    @PostMapping("/signin")
    public String signinProcess02(@ModelAttribute Member paramMember,
                                  Model model) {
        Map<String, String> errorMap = new HashMap<>();
        //데이터가 넘어오는지 안넘어오는지..
        if(!StringUtils.hasText(paramMember.getUserId())){
            errorMap.put("userId","user id는 필수 입력입니다.");
            log.info("user id는 필수 입력입니다.");
        }
        if(!StringUtils.hasText(paramMember.getUserName())) {
            errorMap.put("userName","user name은 필수 입력입니다.");
            log.info("user name은 필수 입력입니다.");
        }
        if(!StringUtils.hasText(paramMember.getUserPw())) {
            errorMap.put("userPw","password은 필수 입력입니다.");
            log.info("password은 필수 입력입니다.");
        }
        if(!errorMap.isEmpty()) {
            model.addAttribute("errorMap",errorMap);
            return "member/signin";
        }
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
//    @PostMapping("/signin")
    public String signinProcess03(@ModelAttribute("paramMember") Member paramMember,
                                  BindingResult bindingResult,
                                  Model model) {
        //데이터가 넘어오는지 안넘어오는지..
        if(!StringUtils.hasText(paramMember.getUserId())){
            bindingResult.addError(new FieldError("paramMember","userId","ID는 필수 입력사항 입니다."));
        }
        if(!StringUtils.hasText(paramMember.getUserPw())){
            bindingResult.addError(new FieldError("paramMember","userPw","비밀번호는 필수 입력사항 입니다."));
        }
        if(!StringUtils.hasText(paramMember.getUserName())){
            bindingResult.addError(new FieldError("paramMember","userName","이름은 필수 입력사항 입니다."));
        }
        if(bindingResult.hasErrors()){
//            model.addAttribute("paramMember",new Member());
            return "member/signin02";
        }
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
    @PostMapping("/signin")
    public String signinProcess04(@Valid @ModelAttribute Member paramMember,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "member/signin03";
        }
        Member saveMember = memberService.saveMember(paramMember);
        log.info("saveMember={}",saveMember.toString());
        return "redirect:/member";
    }
}
