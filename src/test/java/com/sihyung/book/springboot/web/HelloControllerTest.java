package com.sihyung.book.springboot.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
@RunWith(SpringRunner.class)
//스프링 어노테이션 중 Web에 집중할 수 있는 어노테이션
//선언하면 @Controller, ControllerAdvice 등을 사용할 수 있음, @Service, @Component, @Repository 등은 사용할 수 없음
@WebMvcTest
public class HelloControllerTest {

    //스프링이 관리하는 빈(Bean)을 주입함
    @Autowired
    //웹 API를 테스트 할 때 사용함
    //스프링 MVC 테스트의 시작점임
    //이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(MockMvcRequestBuilders.get("/hello")) // mock mvc를 통하여 Http get 요청을 한다.
                .andExpect(MockMvcResultMatchers.status().isOk()) // 결과검증, 200(isOk) 뿐만 아니라 다양한 검증을 할 수 있다.
                .andExpect(MockMvcResultMatchers.content().string(hello)); // 본문의 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                MockMvcRequestBuilders.get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(name)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(amount)));
    }
}
