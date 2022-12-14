package com.example.design.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import com.example.design.DatabaseCleanup;
import com.example.design.domain.GlobalYn;
import com.example.design.domain.Member;
import com.example.design.dto.member.MemberDTO;
import com.example.design.repo.MemberRepo;
import com.example.design.vo.member.MemberRequest;
import com.example.design.vo.member.MemberUpdateRequest;
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

    @Autowired
    private DatabaseCleanup databaseCleanup;

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .addFilters(new CharacterEncodingFilter("UTF-8", true))
                                      .apply(documentationConfiguration(restDocumentation))
                                      .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()),
                                          preprocessResponse(prettyPrint())))
                                      .build();

        databaseCleanup.execute();

        Member member = Member.builder()
                              .name("?????????")
                              .password("1234")
                              .confirm(GlobalYn.Y)
                              .build();

        memberRepo.save(member);
    }


    @Test
    void createMember() throws Exception {
        MemberRequest req = new MemberRequest();
        req.setName("??????");
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
                                                    .description("??????")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("password")
                                                    .description("??????")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("confirm")
                                                    .description("??????")
                                                    .type(JsonFieldType.NULL)
                            ),
                            PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("id")
                                                    .description("?????????")
                                                    .type(JsonFieldType.NULL),
                                PayloadDocumentation.fieldWithPath("name")
                                                    .description("??????")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("confirm")
                                                    .description("????????????")
                                                    .type(JsonFieldType.STRING)
                            )
                        )
                    )
                    .andDo(print());
    }

    @Test
    void updateMember() throws Exception {
        MemberUpdateRequest req = new MemberUpdateRequest();
        req.setId(1L);
        req.setPassword("12345");

        String resultPassword = "12345";

        String content = objectMapper.writeValueAsString(req);

        this.mockMvc.perform(put("/api/member").content(content)
                                               .accept(MEDIA_TYPE_JSON_UTF8)
                                               .contentType(MEDIA_TYPE_JSON_UTF8))
                    .andExpect(status().isOk())
                    .andExpect(result -> memberRepo.findById(1L)
                                                   .orElseThrow()
                                                   .getPassword()
                                                   .equals(resultPassword))
                    .andDo(document("{method-name}", preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            PayloadDocumentation.requestFields(
                                PayloadDocumentation.fieldWithPath("id")
                                                    .description("?????????")
                                                    .type(JsonFieldType.NUMBER),
                                PayloadDocumentation.fieldWithPath("password")
                                                    .description("??????")
                                                    .type(JsonFieldType.STRING)
                            ),
                            PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("id")
                                                    .description("?????????")
                                                    .type(JsonFieldType.NULL),
                                PayloadDocumentation.fieldWithPath("name")
                                                    .description("??????")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("confirm")
                                                    .description("????????????")
                                                    .type(JsonFieldType.STRING)
                            )
                        )
                    )
                    .andDo(print());
    }
}