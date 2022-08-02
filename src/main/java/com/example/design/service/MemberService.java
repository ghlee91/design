package com.example.design.service;

import com.example.design.vo.member.MemberListResponse;
import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    MemberResponse createMember(MemberRequest memberRequest);
    MemberListResponse selectAllMember(Pageable pageable);
}
