package com.example.design.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
public class TaxiMemberSelectedAnswer extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="taxi_member_selected_answer_id")
    private Long id;

    @ManyToOne
    @Comment("택시 서비스 이용 평가항목의 선택 답변")
    @JoinColumn(name="taxi_answer_id")
    private TaxiAnswer taxiAnswer;

    @ManyToOne
    @Comment("FK: 택시 이용 평가 메인 테이블")
    @JoinColumn(name="taxi_evaluation_id")
    private TaxiEvaluation taxiEvaluation;
}
