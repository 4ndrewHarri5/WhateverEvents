package com.machesterdigital.event_manager.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
class DatasourceConfig {

    @Bean(name = "bootcamp")
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://db-workshop.public-dev.zuto.cloud/bootcamp1")
                .username("bootcamp1")
                .password("LlamaPancakes")
                .build();
    }

    @Bean(name = "local")
    @Primary
    public DataSource dataSourceLocal(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3307/whateverdb")
                .username("user")
                .password("password")
                .build();
    }

}