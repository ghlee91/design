package com.example.design.vo.member;

import lombok.Data;

@Data
public class MemberListRequest {
    private int pageSize;
    private int pageNumber;
}
