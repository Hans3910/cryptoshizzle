package com.example.crypto.rest.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CryptoRestControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testFindAllCoins() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/coins"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Bitcoin")))
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testFindById() throws Exception {
        this.mockMvc.perform(get("/coins/138"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Bitcoin")))
                .andReturn();
    }

    @Test
    public void testGetcoinById_InvalidId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/coins/1000"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals("Coin with id: 1000 not found.", mvcResult.getResponse().getErrorMessage());
    }
}