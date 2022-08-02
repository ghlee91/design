package com.example.design.vo.member;

import lombok.Data;

@Data
public class MemberRequest {
    private String password;
    private String name;
    private String confirm;
}