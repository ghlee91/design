package com.example.design.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
public class TaxiEvaluation extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Comment("택시 평가 인덱스")
    @Column(name="taxi_evaluation_id")
    private Long id;

    @OneToOne
    @Comment("택시 매칭 인덱스")
    private TaxiMatch taxiMatch;

    @Comment("택시기사 다시는 만나고 싶지 않아요(Y, N)")
    @Enumerated(EnumType.STRING)
    private GlobalYn driverBan;

    @Comment("불편사항")
    private String StringComfirm;



}