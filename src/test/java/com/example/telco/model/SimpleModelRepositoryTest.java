package com.example.telco.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class SimpleModelRepositoryTest {

    @Autowired
    SimpleModelRepository repository;

    @Test
    public void testSuccessfulSave() throws Exception {
        SimpleModel simpleModel = new SimpleModel();
        simpleModel.setName("test");
        //test
        assertNull(simpleModel.getId());
        //save
        simpleModel = repository.save(simpleModel);
        //test
        assertNotNull(simpleModel.getId());
    }
}
