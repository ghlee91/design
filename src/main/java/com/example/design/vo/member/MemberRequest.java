package com.example.design.vo.member;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberRequest {
    private String password;
    private String name;
    private String confirm;
}