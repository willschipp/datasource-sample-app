package com.example.telco.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * cloud configuration for the injection of two datasources by PCF
 */
@Configuration
@Profile("cloud")
public class DatasourceConfiguration extends AbstractCloudConfig {

    private String datasource1 = "sample-db-one"; //names set from PCF

    private String datasource2 = "sample-db-two";

    @Bean(name="dataSource") //consistent bean names
    public DataSource dataSource() {
        return connectionFactory().dataSource(datasource1);
    }

    @Bean(name="otherDataSource")
    public DataSource otherDataSource() {
        return connectionFactory().dataSource(datasource2);
    }

}
