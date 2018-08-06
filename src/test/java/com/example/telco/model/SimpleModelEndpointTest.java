package com.example.telco.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleModelEndpointTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    SimpleModelRepository repository;

    MockMvc mvc;


    @Before
    public void before() throws Exception {
        mvc = webAppContextSetup(context).build();
    }

    @After
    public void after() throws Exception {
        repository.deleteAllInBatch();
    }

    @Test
    public void testSuccessfulSave() throws Exception {
        //setup
        SimpleModel model = new SimpleModel();
        model.setName("test");
        //convert
        String modelJSON = mapper.writeValueAsString(model);
        //test
        mvc.perform(post("/simpleModel").content(modelJSON)).andExpect(status().isCreated());
    }
}
