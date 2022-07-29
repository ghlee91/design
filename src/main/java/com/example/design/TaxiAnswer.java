package com.example.design;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaxiAnswer extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taxiAnswerId;

    @ManyToOne
    @Comment("Taxi Question FK")
    @JoinColumn(name = "question_id")
    private TaxiQuestion question;

    @Comment("질문에 대한 답변항목 순서")
    private String orderOfAnswer;

    @Comment("답변내용")
    private String answerContent;

    @Comment("삭제여부")
    @Enumerated(EnumType.STRING)
    private GlobalYn deleteYn;

}