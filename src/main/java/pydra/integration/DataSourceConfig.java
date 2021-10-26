package pydra.integration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){

        DataSource dataSource = null;

        DataSourceBuilder builder = DataSourceBuilder.create();

        builder.url("jdbc:oracle:thin:@//154.57.7.107:1521/orcl.site");
        builder.username("kardi");
        builder.password("kardi");
        builder.driverClassName("oracle.jdbc.OracleDriver");

        dataSource = builder.build();

        return dataSource;

    }
}
