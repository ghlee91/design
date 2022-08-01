package com.example.design.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Favorite extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "favorite_id")
    private Long id;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @BatchSize(size = 1)
    @JoinColumn(name="member_id")
    private Member member;

    @Column(length = 20)
    @Comment("즐겨찾기 종류")
    private String favoriteType;

    @Comment("즐겨찾기 위도")
    private double favoriteLatitude;

    @Comment("즐겨찾기 경도")
    private double favoriteLongitude;

    @Comment("즐겨찾기 주소")
    private String favoriteAddress;
}
