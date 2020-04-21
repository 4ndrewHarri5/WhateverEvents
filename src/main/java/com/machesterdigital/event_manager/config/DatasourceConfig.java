package com.machesterdigital.event_manager.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class DatasourceConfig {

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://db-workshop.public-dev.zuto.cloud/bootcamp1")
                .username("bootcamp1")
                .password("LlamaPancakes")
                .build();
    }

}