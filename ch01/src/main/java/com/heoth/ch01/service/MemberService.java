package com.heoth.ch01.service;

import com.heoth.ch01.dto.Member;
import com.heoth.ch01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    //repository
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        Member saveMember = memberRepository.save(member);
        return saveMember;
    }
    public List<Member>findAllMember (){
        List<Member> members = memberRepository.findAll();
        return members;
    }
    public Optional<Member> findMember(int idx){
        return memberRepository.findMember(idx);
    }
}
