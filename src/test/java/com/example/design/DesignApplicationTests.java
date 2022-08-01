package com.example.design;

import com.example.design.domain.Favorite;
import com.example.design.domain.Member;
import com.example.design.repo.FavoriteRepo;
import com.example.design.repo.MemberRepo;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private FavoriteRepo favoriteRepo;

    @Test
    void memberTest() {
        Member member = memberRepo.findById(1L).orElseThrow();
//        memberRepo.findById()
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);
        System.out.println(member);

    }

    @Test
    void FavoriteTest(){
        List<Favorite> favorite =  favoriteRepo.findByMemberId(1L);

        System.out.println(favorite);

    }


    @Test
    void contextLoads() {

    }

}
