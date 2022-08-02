package com.example.design.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.example.design.repo.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {

    @Autowired
    private MemberRepo memberRepo;

    @Test
    void hihi() {
        Member member = Member.builder()
                              .name("소니")
                              .password("1234")
                              .confirm(GlobalYn.Y)
                              .build();

        memberRepo.save(member);
        System.out.println(member.toString());
    }
}