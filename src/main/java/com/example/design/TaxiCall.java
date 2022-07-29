package com.example.design;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Comment;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaxiCall extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taxi_call_id")
    @Comment("PK")
    private Long id;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "member_id")
    @Comment("FK")
    private Member member;

    @Column(length = 20)
    @Comment("코나투스(반반택시)에서 응답한 호출 아이디")
    private int konatusCallId;

    @Column(length = 15)
    @Comment("연동사 코드")
    private String companyCode;

    @Column(length = 20)
    @Comment("호출종류(일반호출: BASIC, 동승호출: SHARE)")
    private String callType;

    @Column(length = 20)
    @Comment("호출종류(일반호출: BASIC, 동승호출: SHARE)")
    private String callOption;

    @Column(length = 50)
    @Comment("호출상태")
    private String callStatus;

    @Comment("출발지 위도")
    private double startLatitude;
    @Comment("출빌지 경도")
    private double startLongitude;
    @Column(length = 255)
    @Comment("출발지 주소")
    private String startAddress;

    @Comment("도착지 위도")
    private double endLatitude;
    @Comment("도착지 경도")
    private double endLongitude;
    @Column(length = 255)
    @Comment("도착지 주소")
    private String endAddress;

    @Column(length = 30)
    @Comment("호출시간")
    private String callTime;

    @Column(length = 20)
    @Comment("결제수단(신용카드:CREDIT_CARD, 현장결제:DIRECT)")
    private String payMethod;

    @OneToOne
    @Comment("결제수단")
    @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;
}