package com.example.telco.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PoorlyWrittenEndpointTest {

    @Autowired
    PoorlyWrittenEndpoint endpoint;

    @Test
    public void testSuccessfulCount() throws Exception {
        //invoke the endpoint directly and get a count
        assertTrue(endpoint.getCount() <= 0);
    }
}
