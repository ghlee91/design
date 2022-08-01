package com.example.design.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Comment("이름")
    @Column(name = "name", length = 50)
    private String name;

    @Comment("패스워드")
    @Column(name = "password", length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Comment("본인확인 완료여부")
    private GlobalYn confirm;

 }