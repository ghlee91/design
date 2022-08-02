package com.example.design.repo;

import com.example.design.domain.Member;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long Id);
    Page<Member> findAll(Pageable pageable);
}
