package com.example;

import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class AbstractApiControllerTest extends AbstractControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
    );
	
	@Autowired
    protected WebApplicationContext webApplicationContext;
	
	protected MockMvc mvc;
	
	@Before
	public void setUp(){
		super.setUp();
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@After
	public void tearDown(){
		super.tearDown();
	}
	
}
