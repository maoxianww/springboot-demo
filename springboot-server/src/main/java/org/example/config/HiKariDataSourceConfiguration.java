package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @auth: w
 * @desc: 多数据源配置
 * @date: 2023/10/17 15:15
 */
@Configuration
public class HiKariDataSourceConfiguration {

    @Primary
    @Bean("primaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties paimaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean("primaryDataSource")
    @Qualifier(value =  "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary.hikari")
    public HikariDataSource primaryDataSource() {
        return paimaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate parimaryJdbcTemplate(@Qualifier(value =  "primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("secondaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("secondaryDataSource")
    @Qualifier(value =  "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary.hikari")
    public HikariDataSource secondaryDataSource() {
        return secondaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "secondaryJdbcTemplate")
    @Qualifier(value =  "secondaryDataSource")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier(value =  "secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
