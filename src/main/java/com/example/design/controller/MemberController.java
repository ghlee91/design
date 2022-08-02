package com.example.design.controller;

import com.example.design.service.MemberServiceImpl;
import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberResponse;
import com.example.design.vo.member.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberServiceImpl memberService;

    @GetMapping("/hello")
    public String hello(MemberRequest memberRequest) {
        System.out.println(memberRequest.getPassword());
        System.out.println(memberRequest.getName());
        System.out.println(memberRequest.getConfirm());
        System.out.println("ㅎㅎ");
        return "헬로 월드";
    }

    @PostMapping("/member")
    public ResponseEntity createMember(@RequestBody MemberRequest memberRequest) {
        log.info("{}", memberRequest);
        MemberResponse member = memberService.createMember(memberRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(member);
    }

    @PutMapping("/member")
    public ResponseEntity updateMember(@RequestBody MemberUpdateRequest memberUpdateRequest) {
        log.info("{}", memberUpdateRequest);
        MemberResponse member = memberService.updateMember(memberUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(member);
    }


}
