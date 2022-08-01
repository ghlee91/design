package com.example.design.service;

import com.example.design.domain.GlobalYn;
import com.example.design.domain.Member;
import com.example.design.dto.member.MemberDTO;
import com.example.design.repo.MemberRepo;
import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepo memberRepo;
    private final ModelMapper modelMapper;

    @Override
    public MemberResponse createMember(MemberRequest memberRequest) {
        MemberDTO memberDTO = modelMapper.map(memberRequest, MemberDTO.class);

        Member member = Member.builder()
                              .name(memberDTO.getName())
                              .password(memberDTO.getPassword())
                              .confirm(GlobalYn.Y)
                              .build();

        memberRepo.save(member);

        memberDTO = MemberDTO.builder()
                             .name(member.getName())
                             .confirm(String.valueOf(member.getConfirm()))
                             .build();

        return modelMapper.map(memberDTO, MemberResponse.class);
    }
}