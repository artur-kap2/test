package com.example.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testDivProperInputParameters() throws Exception {
        mvc.perform(get("/div/10/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"value\":5.0}"));
    }

    @Test
    public void testDivDivideByZero() throws Exception {
        mvc.perform(get("/div/10/0"))
                .andExpect(status().is(400));
    }

    @Test
    public void testDivNotAllParametersPassed() throws Exception {
        mvc.perform(get("/div/10"))
                .andExpect(status().is(404));
    }

    @Test
    public void testDivNotAllowedMethod() throws Exception {
        mvc.perform(post("/div/10/2"))
                .andExpect(status().is(405));

    }

    @Test
    public void testAddProperInputParameters() throws Exception {
        mvc.perform(post("/add/10/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"value\":12.0}"));
    }


    @Test
    public void testAddNotAllParametersPassed() throws Exception {
        mvc.perform(post("/add/10"))
                .andExpect(status().is(404));
    }

    @Test
    public void testAddNotAllowedMethod() throws Exception {
        mvc.perform(get("/add/10/2"))
                .andExpect(status().is(405));

    }
}
