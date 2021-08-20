package com.translator.xtm.controller;

import com.translator.xtm.service.TranslateService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TranslateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void withBody() throws Exception {
        mockMvc.perform(
                post("/xtm/translate/{specific}", true)
                .content("Ala"))
                .andExpect(status().isOk());
    }

    @Test
    void withoutBody() throws Exception {
        mockMvc.perform(
                post("/xtm/translate/{specific}", true))
                .andExpect(status().isBadRequest());
    }

    @Test
    void translate() throws Exception {
        mockMvc.perform(
                post("/xtm/translate/{specific}", false)
                .content("Ala")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Alice")));
    }

}