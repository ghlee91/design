package com.example.design.service;

import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;
import com.example.design.vo.member.MemberUpdateRequest;

public interface MemberService {
    MemberResponse createMember(MemberRequest memberRequest);

    MemberResponse updateMember(MemberUpdateRequest memberUpdateRequest);
}
