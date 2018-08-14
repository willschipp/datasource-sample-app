package com.example.telco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class ApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void testSuccessfulStartup() throws Exception {
        assertTrue(context.getBeanDefinitionCount() > 0);
    }

    @Test(expected = BadSqlGrammarException.class)
    public void testJpaDataSourceDoesNotHaveTable() throws Exception {
        new JdbcTemplate(context.getBean("dataSource", DataSource.class)).queryForObject("select count(*) from sample_table",Integer.class);
    }

    @Test
    public void testOtherDataSourceHasTable() throws Exception {
        assertTrue(new JdbcTemplate(context.getBean("otherDataSource", DataSource.class)).queryForObject("select count(*) from sample_table",Integer.class) == 0);
    }
}
