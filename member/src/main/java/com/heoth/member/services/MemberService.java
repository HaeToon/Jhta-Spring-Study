package com.heoth.member.services;

import com.heoth.member.dto.Member;


import java.util.HashMap;
import java.util.Map;

public class MemberService {
    public static final Map<Integer, Member> memberStore = new HashMap<>();
    private static Integer sequence=0;
    //1. new member ()
    public Member saveMember(Member member){
        member.setIdx(++sequence);
        memberStore.put(member.getIdx(),member);
        return member;
    }

}
