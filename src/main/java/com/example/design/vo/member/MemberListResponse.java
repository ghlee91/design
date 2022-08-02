package com.example.design.vo.member;

import com.example.design.domain.Member;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class MemberListResponse {
     private Page<Member> memberList;
}
