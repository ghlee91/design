package com.example.design.domain;

import javax.persistence.Column;
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
public class PaymentMethod extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_method_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Comment("카드이름(사용자 설정)")
    @Column(name = "card_alias")
    private String cardAlias;

    @Comment("메인 결제수단 여부(메인:Y, 그외:N)")
    @Column(name = "main_payment")
    private GlobalYn mainPayment;

    @Comment("PG사에서 발급된 빌키")
    @Column(name = "bill_key")
    private String billKey;

    @Comment("카드이름(사용자 설정)")
    @Column(name = "card_number")
    private String cardNumber;

    @Comment("카드사(PG에서 반환된 카드사명)")
    @Column(name = "card_company")
    private String cardCompany;

    @Comment("개인/법인(개인: INDIVIDUAL, 법인: CORPORATION)")
    @Column(name = "card_type")
    private String cardType;

    @Comment("삭제여부(미삭제:N, 삭제:Y)")
    @Enumerated(EnumType.STRING)
    @Column(name = "delete_yn")
    private GlobalYn deleteYn;

}
