package com.example.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.AbstractApiControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ItemControllerTest extends AbstractApiControllerTest {
	
	/**
     * /item/detail/1
     * @throws Exception
     */
    @Test
    public void testSampleTest1() throws Exception {
    	
    	Integer id;
    	id = 1;
    	
    	// 実行し、値を検証
        mvc.perform(get("/item/detail/{id}", id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("id", is(1)))
            .andExpect(jsonPath("name", is("apple")))
            .andExpect(jsonPath("price", is(120)))
            .andExpect(jsonPath("createAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("updateAt", is(Long.valueOf("1483461861000"))));
    }
    
    /**
     * /item/list
     * @throws Exception
     */
    @Test
    public void testSampleTest2() throws Exception {
    	
    	// 実行し、値を検証
        mvc.perform(get("/item/list"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].name", is("apple")))
            .andExpect(jsonPath("$[0].price", is(120)))
            .andExpect(jsonPath("$[0].createAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("$[0].updateAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].name", is("orange")))
            .andExpect(jsonPath("$[1].price", is(150)))
            .andExpect(jsonPath("$[1].createAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("$[1].updateAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("$[2].id", is(3)))
            .andExpect(jsonPath("$[2].name", is("grape")))
            .andExpect(jsonPath("$[2].price", is(200)))
            .andExpect(jsonPath("$[2].createAt", is(Long.valueOf("1483461861000"))))
            .andExpect(jsonPath("$[2].updateAt", is(Long.valueOf("1483461861000"))));
    }
	
}
