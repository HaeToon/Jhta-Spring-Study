package com.heoth.ch01.repository;

import com.heoth.ch01.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {
    private static final Map<Integer, Member>memberMap = new HashMap<>();
    private static Integer seq =0;
    public Member save(Member member){
        member.setIdx(++seq);
        memberMap.put(member.getIdx(),member);
        return member;
    }
    public List<Member>findAll() {
        return new ArrayList<>(memberMap.values());
    }
    public Optional<Member> findMember(int idx){
        //Optional Npe null로 떨어질수있는 경우에
        Optional<Member> findMember = Optional.ofNullable(memberMap.get(idx));
        return findMember;
    }
}
