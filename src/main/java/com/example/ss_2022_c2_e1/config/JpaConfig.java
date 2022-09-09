package com.example.ss_2022_c2_e1.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean(name = "h2DataSource")
    @ConfigurationProperties("h2.datasource")
    public DataSource h2DataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost/spring_data");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("stoRTY2105*");
        return dataSourceBuilder.build();
    }
}
