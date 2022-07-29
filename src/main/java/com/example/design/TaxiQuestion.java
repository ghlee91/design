package com.example.design;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
public class TaxiQuestion extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taxi_question_id")
    private Long taxiQuestionId;

    @Comment("질문 내용")
    @Column(name = "question_content")
    private String questionContent;

    @Comment("삭제여부")
    @Column(name = "delete_yn")
    @Enumerated(EnumType.STRING)
    private GlobalYn deleteYn;


}
