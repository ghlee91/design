package com.example.design;

import com.example.design.domain.GlobalYn;
import com.example.design.domain.Member;
import com.example.design.repo.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(readOnly = true)
public class EntityTest {
    @Autowired
    private MemberRepo memberRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void entityTest() {
        Member member = Member.builder()
                             .name("김영한짱")
                             .confirm(GlobalYn.Y)
                             .password("영한1234")
                             .build();
        System.out.println("member 전 = " + member);
        System.out.println("member.getCreatedAt() = " + member.getCreatedAt());
//        member.onPrePersist();
        Member memberSaved = this.memberRepo.save(member);
        System.out.println("=================================================");
        System.out.println("member.getCreatedAt() = " + member.getCreatedAt());
        System.out.println("member.getCreatedAtByTaxi() = " + member.getCreatedAtFommat());
        System.out.println("member 후 = " + member);
        System.out.println("memberSaved = " + memberSaved);
        if (member == memberSaved) {
            System.out.println("헤윙");
        }
    }

}
