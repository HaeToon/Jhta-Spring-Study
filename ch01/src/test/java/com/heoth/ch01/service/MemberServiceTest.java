package com.heoth.ch01.service;

import com.heoth.ch01.dto.Member;
import com.heoth.ch01.repository.MemberRepository;
import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("member repository에서 저장한 member 랑 리턴되는 member가 같다.")
    void saveMember() {
        Member member = Member.builder()
                .userId("heoth")
                .userPw("1234")
                .userName("허태훈")
                .build();
        Member savedMember = memberRepository.save(member);
        Assertions.assertThat(member).isEqualTo(savedMember);
//        Assertions.assertThat(1+1).isEqualTo(2);
    }

    @Test
    @DisplayName("1+2 = 3")
    void test03(){
        Assertions.assertThat(1+1).isEqualTo(2);
    }
    @Test
    void test04(){
        int num01 = 10;
        int num02 = 0;
        int num03 = -20;

        String userName = "허태훈";
        String dbName = "태훈허";

        Assertions.assertThat(num01).isPositive();
        Assertions.assertThat(num02).isZero();
        Assertions.assertThat(num03).isNegative();

        Assertions.assertThat(userName).isNotNull();
        Assertions.assertThat(dbName).isNotNull();
        Assertions.assertThat(userName).isNotEqualTo(dbName);

    }

    @Test
    void findAllMember() {
        Member member = Member.builder()
                .userId("heoth")
                .userPw("1234")
                .userName("허태훈")
                .build();
        Member member02 = Member.builder()
                .userId("heoth")
                .userPw("1234")
                .userName("허태훈")
                .build();

        memberRepository.save(member);
        memberRepository.save(member02);
        List<Member>memberList =  memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(2);

    }

    @Test
    void findMember() {
    }
}