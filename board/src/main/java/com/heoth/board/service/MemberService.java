package com.heoth.board.service;

import com.heoth.board.dao.MemberDao;
import com.heoth.board.dto.LoginDto;
import com.heoth.board.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberDao memberDao;
    public int signIn(LoginDto loginDto ){
        return memberDao.signIn(loginDto);
    }
    public int signUp(MemberDto memberDto){
        return memberDao.signUp(memberDto);
    }
    public int duplicateID(String userID){
        return memberDao.duplicateID(userID);
    }
    public MemberDto loginInfo (LoginDto loginDto){
        return memberDao.getLoginInfo(loginDto);
    }
}
