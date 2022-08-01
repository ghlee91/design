package com.example.design.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaxiServiceFee extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    @Column(name = "taxi_service_fee_id")
    private Long id;

    @OneToOne
    @NonNull
    @JoinColumn(name="call_id")
    @Comment("FK")
    private TaxiCall callId;

    @Comment("총 이용요금")
    private int totalFare;
    @Comment("미터기 요금")
    private int meterFare;
    @Comment("통행료")
    private int tollFare;
    @Comment("호출료")
    private int serviceFee;
}
