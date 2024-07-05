package com.heoth.ch01.controller;

import com.heoth.ch01.dto.Member;
import com.heoth.ch01.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {
    //3가지 주입방식  1.@Autowired setter주입방식 2.생성자주입방식 3.
    private final TestService testService;
    //생성자 주입방식
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }

    //    @Autowired
//    TestService testService; //제어의역전
    @GetMapping("/aa")
//    @ResponseBody
    public String aa(){
        testService.test();
        return "aa";
    }
//    @GetMapping("/member")
//    @ResponseBody // json 으로 변환?됨
//    public List<Member> responseMember(){
//        List<Member> memberList = new ArrayList<>();
//        Member member01 = Member.builder()
//                .userID("heoth")
//                .userPW("1234")
//                .userName("h태훈")
//                .build();
//        Member member02 = Member.builder()
//                .userID("seoth")
//                .userPW("1234")
//                .userName("s태훈")
//                .build();
//        memberList.add(member01);
//        memberList.add(member02);
//
//        return memberList;
//    }
}
