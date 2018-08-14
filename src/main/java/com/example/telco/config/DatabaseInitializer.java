package com.example.telco.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * initializer class to populate the database
 * Spring Boot automatic initializer is overridden due to having 2 datasources
 */
@Service
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log logger = LogFactory.getLog(DatabaseInitializer.class);

    @Value("${datasource.schema}")
    private String sqlFile;

    @Value("${datasource.name}")
    private String beanName;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        DatabasePopulator populator =  new ResourceDatabasePopulator();
        ((ResourceDatabasePopulator) populator).setScripts(new ClassPathResource(sqlFile));
        ((ResourceDatabasePopulator) populator).setContinueOnError(true);
        //execute
        ((ResourceDatabasePopulator) populator).execute(contextRefreshedEvent.getApplicationContext().getBean(beanName, DataSource.class));
    }
}
