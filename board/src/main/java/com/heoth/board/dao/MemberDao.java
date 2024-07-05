package com.heoth.board.dao;

import com.heoth.board.dto.LoginDto;
import com.heoth.board.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    public int signIn(LoginDto loginDto);
    public int signUp(MemberDto memberDto);
    public int duplicateID(String userID);
    public MemberDto getLoginInfo(LoginDto loginDto);
}
