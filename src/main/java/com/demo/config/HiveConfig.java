package com.demo.config;

import com.demo.properties.HiveProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @ClassName: HiveConfig
 * @Author: djsoft wpf
 * @Description: HiveConfig
 * @Date: 2020/10/30 9:03
 */
@Configuration
public class HiveConfig {

    private static final Logger logger = LoggerFactory.getLogger(HiveConfig.class);

    @Bean(name = "hiveDruidDataSource")
    @Qualifier("hiveDruidDataSource")
    public DruidDataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        // base Configuration
        datasource.setUrl(HiveProperties.URL);
        datasource.setDriverClassName(HiveProperties.DRIVER_CLASSNAME);
        datasource.setUsername(HiveProperties.USERNAME);
        datasource.setPassword(HiveProperties.PASSWORD);
        // pool Configuration
        datasource.setInitialSize(HiveProperties.INITIALSIZE);
        datasource.setMinIdle(HiveProperties.MIN_IDLE);
        datasource.setMaxActive(HiveProperties.MAX_ACTIVE);
        datasource.setMaxWait(HiveProperties.MAX_WAIT);
        datasource.setTimeBetweenEvictionRunsMillis(HiveProperties.TIME_BETWEEN_EVICTION_RUNS_MILLIS);
        datasource.setMinEvictableIdleTimeMillis(HiveProperties.MIN_EVICTABLE_IDLE_TIME_MILLIS);
        datasource.setValidationQuery(HiveProperties.VALIDATION_QUERY);
        datasource.setTestWhileIdle(HiveProperties.TEST_WHILE_IDLE);
        datasource.setTestOnBorrow(HiveProperties.TEST_ONBORROW);
        datasource.setTestOnReturn(HiveProperties.TEST_ONRETURN);
        datasource.setPoolPreparedStatements(HiveProperties.POOL_PREPAREDSTATEMENTS);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(HiveProperties.MAX_POOL_PREPAREDSTATEMENT_PERCONNECTIONSIZE);
        logger.info("Hive DataSource Injecting\n"+datasource.toString());
        logger.info("Hive DataSource Inject Successfully...");
        return datasource;
    }

    @Bean(name = "hiveDruidTemplate")
    public JdbcTemplate hiveJdbcTemplate(@Qualifier("hiveDruidDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
