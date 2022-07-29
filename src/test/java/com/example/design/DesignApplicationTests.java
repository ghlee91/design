package com.example.design;

import com.example.design.repo.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private MemberRepo memberRepo;

    @Test
    void memberTest() {
        Member member = memberRepo.findById(1L).orElseThrow();

        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
    }

    @Test
    void contextLoads() {

    }

}
