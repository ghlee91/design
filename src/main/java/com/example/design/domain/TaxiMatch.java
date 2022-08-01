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
public class TaxiMatch extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    @Comment("PK")
    private Long id;

    @OneToOne
    @NonNull
    @JoinColumn(name = "call_id")
    @Comment("FK")
    private TaxiCall callId;

    @Comment("FK")
    private int driverId;

    @Column(length = 10)
    @Comment("기사 타입(개인: PRIVATE, 법인:COMPANY)")
    private String driverType;

    @Column(length = 20)
    @Comment("택시기사 이름")
    private String driverName;

    @Column(length = 13)
    @Comment("택시기사 연락처")
    private String driverPhoneNumber;

    @Column(length = 9)
    @Comment("차량번호")
    private String driverTaxiNumber;

    @Column(length = 20)
    @Comment("차량모델")
    private String driverTaxiModelName;

    @Column(length = 20)
    @Comment("호출수락일시(YYYY-MM-DD HH24:MI:SS)")
    private String acceptedAt;

    @Column(length = 20)
    @Comment("탑승일시(YYYY-MM-DD HH24:MI:SS)")
    private String startAt;

    @Column(length = 20)
    @Comment("하차일시(YYYY-MM-DD HH24:MI:SS)")
    private String endAt;

}
