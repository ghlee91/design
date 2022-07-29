package com.example.design;

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

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    @Column(name = "car_number", length = 15)
    private String carNumber;
    @Column(name = "car_name", length = 20)
    private String carName;
    @Column(name ="car_type", length = 10)
    private String carType;
    @Enumerated(EnumType.STRING)
    private GlobalYn owner;


}
