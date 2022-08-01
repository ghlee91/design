package com.example.design.repo;

import com.example.design.domain.Favorite;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    List<Favorite> findByMemberId(Long member_id);
}
