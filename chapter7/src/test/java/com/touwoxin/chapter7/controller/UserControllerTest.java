package com.touwoxin.chapter7.controller;

import com.touwoxin.chapter7.Chapter7Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter7Application.class)
public class UserControllerTest {
    // 注入Spring容器
    @Autowired
    private WebApplicationContext wac;
    // MockMvc实现了对Http请求的模拟
    private MockMvc mvc;
    @Before
    public void setupMockMvc(){
        //初始化MockMvc对象
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 新增用户测试用例
     * @throws Exception
     */
    @Test
    @Transactional
    public void saveUserTest() throws Exception{
        String json= "{\"username\":\"孙悟空\",\"password\":\"pwd\",\"email\":\"email@qq.com\"}";
        mvc.perform(MockMvcRequestBuilders.post("/user/saveUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 获取用户信息测试用例
     * @throws Exception
     */
    @Test
    public void queryUserByIdTest () throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/queryUserById/27")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("user333"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("333@qq.com"))
                .andDo(MockMvcResultHandlers.print());
    }
}

