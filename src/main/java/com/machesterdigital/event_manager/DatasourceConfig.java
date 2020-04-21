package com.machesterdigital.event_manager;

import javax.sql.DataSource;

@Configuration
class DatasourceConfig {

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create
    }


}