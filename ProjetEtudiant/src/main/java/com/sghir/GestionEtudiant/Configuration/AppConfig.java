package com.sghir.GestionEtudiant.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.sghir.GestionEtudiant")
@PropertySource("classpath:app.properties")
public class AppConfig
{
    @Value("${jdbc.url.datasource}")
    private String url;


    @Value("${jdbc.url.username}")
    private String username;

    @Value("${jdbc.url.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }


}
