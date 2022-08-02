package com.example.design.service;

import com.example.design.vo.member.MemberListResponse;
import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;
import com.example.design.vo.member.MemberUpdateRequest;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    MemberResponse createMember(MemberRequest memberRequest);
    MemberResponse updateMember(MemberUpdateRequest memberUpdateRequest);
    MemberListResponse selectAllMember(Pageable pageable);
}
