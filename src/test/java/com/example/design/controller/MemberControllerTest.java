package com.example.design.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import com.example.design.domain.GlobalYn;
import com.example.design.domain.Member;
import com.example.design.dto.member.MemberDTO;
import com.example.design.repo.MemberRepo;
import com.example.design.vo.member.MemberRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class MemberControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepo memberRepo;

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .addFilters(new CharacterEncodingFilter("UTF-8", true))
                                      .apply(documentationConfiguration(restDocumentation))
                                      .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()),
                                          preprocessResponse(prettyPrint())))
                                      .build();

        //databaseCleanup.execute();

        Member member = Member.builder()
                              .name("이기하")
                              .password("1234")
                              .confirm(GlobalYn.Y)
                              .build();

        memberRepo.save(member);
    }


    @Test
    void createMember() throws Exception {
        MemberRequest req = new MemberRequest();
        req.setName("쏘니");
        req.setPassword("1234");

        String content = objectMapper.writeValueAsString(req);

        this.mockMvc.perform(post("/api/member").content(content)
                                                .accept(MEDIA_TYPE_JSON_UTF8)
                                                .contentType(MEDIA_TYPE_JSON_UTF8))
                    .andExpect(status().isCreated())
                    .andDo(document("{method-name}", preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            PayloadDocumentation.requestFields(
                                PayloadDocumentation.fieldWithPath("name")
                                                    .description("이름")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("password")
                                                    .description("비번")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("confirm")
                                                    .description("컨펌")
                                                    .type(JsonFieldType.NULL)
                            ),
                            PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("id")
                                                    .description("아이디")
                                                    .type(JsonFieldType.NULL),
                                PayloadDocumentation.fieldWithPath("name")
                                                    .description("이름")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("confirm")
                                                    .description("확인여부")
                                                    .type(JsonFieldType.STRING)
                            )
                        )
                    )
                    .andDo(print());
    }
}