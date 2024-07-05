package com.heoth.member.controller;

import com.heoth.member.dto.Member;
import com.heoth.member.services.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class MemberController {
    MemberService memberService = new MemberService();
    @GetMapping("/signin")
    public String signin(){
        return "member/signin";
    }
    @PostMapping("/signin")
    public String signinProcess(@ModelAttribute Member member , RedirectAttributes redirectAttributes){
        log.info("member==={}",member);
        MemberService memberService = new MemberService();
        Member saveMember = memberService.saveMember(member);
        log.info("saveMember==={}",saveMember.getIdx());
        redirectAttributes.addAttribute("itemId",saveMember.getIdx());
        redirectAttributes.addAttribute("status",true);

        return "redirect:member/1";
    }
    @GetMapping("/member/{idx}")
    public String findMember(@PathVariable int idx, Model model){
//        Member findMember = memberService.findMember(idx);
//        model.addAttribute("findMember",findMember);
        return "member/member";
    }
}
