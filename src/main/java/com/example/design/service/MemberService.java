package com.example.design.service;

import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;

public interface MemberService {
    MemberResponse createMember(MemberRequest memberRequest);
}
