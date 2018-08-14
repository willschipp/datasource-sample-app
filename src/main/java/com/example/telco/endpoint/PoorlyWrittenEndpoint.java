package com.example.telco.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@RestController
@RequestMapping("/other")
public class PoorlyWrittenEndpoint {

    private static final String SQL = "select count(*) from sample_table";

    @Autowired
    private DataSource otherDataSource;

    @RequestMapping(method= RequestMethod.GET)
    public int getCount() throws Exception {
        JdbcTemplate template = new JdbcTemplate(otherDataSource);
        return template.queryForObject(SQL,Integer.class);
    }
}
