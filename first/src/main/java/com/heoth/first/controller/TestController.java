package com.heoth.first.controller;

import com.heoth.first.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class TestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());
    //spring container에 bean 으로 등록

    @GetMapping("/user")
    @ResponseBody
    public String testController02(Model model){
//        log.error();
//        log.debug();
//        log.warn();
//        log.info();
        return "html/test02";
    }

//    @GetMapping("/test")
    public String testController(Model model, HttpServletRequest request){
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

//        dispatcher.forward
        //templates/filename.html 을 default 로 찾음.
        model.addAttribute("name","heoth");
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");

        return "html/test";
    }
//    @GetMapping("/test")
    public String testControllerRequestParam(Model model, @RequestParam("username") String username , @RequestParam("age") int age ){
//        dispatcher.forward
        //templates/filename.html 을 default 로 찾음.

        int myage = age+20;

        log.info("username={},age={}",username,age);

        model.addAttribute("name","heoth");
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");

        return "html/test";
    }
    @GetMapping("/test")
    public String testControllerRequestParam02(Model model,@RequestParam(required = false , defaultValue = "none") String username ,@RequestParam(required = false , defaultValue = "10") Integer age,@RequestParam(required = false)List<String> member){

//        int myage = age+20;

        log.info("username={},age={}",username,age);

        model.addAttribute("name","heoth");
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");
        model.addAttribute("member",member);
        return "html/test";
    }

    @GetMapping("/variable")
    public String testController03(Model model){
        String name = "heoth";
        int age=27;
        Member memberDto = Member.builder()
                .userName(name)
                .userAge(age)
                .build();
        model.addAttribute("member",memberDto);

        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("kim",30));
        memberList.add(new Member("jim",40));
        memberList.add(new Member("im",50));
        memberList.add(new Member("him",60));

        model.addAttribute("memberList",memberList);

        Member member01 = new Member("heo",20);
        Member member02 = new Member("kim",20);


        Map<String,Member> map = new HashMap<>();
        map.put("member01",member01);
        map.put("member02",member02);

        model.addAttribute("map",map);

        return "html/variable";

    }

    @GetMapping("/link")
    public String link(Model model){
        //view resolver ("/template/"+html/link+".html")
        model.addAttribute("param01","heoth");
        model.addAttribute("param02",20);

        return "html/link";
    }
}
