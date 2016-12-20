package com.example.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

/**
 * Created by wanglimin1 on 2016/12/9.
 */
@Component
public class DruidDataSourceBase {

    DruidDataSource getDruidDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }

     /*private DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setTimeBetweenConnectErrorMillis(properties.getTimeBetweenConnectErrorMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setRemoveAbandoned(properties.isRemoveAbandoned());
        dataSource.setRemoveAbandonedTimeoutMillis(properties.getRemoveAbandonedTimeoutMillis());
        dataSource.setLogAbandoned(properties.isLogAbandoned());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.getTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.getPoolPreparedStatements());
        dataSource.setFilters(properties.getFilters());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setConnectionProperties(properties.getConnectionProperties());
        return dataSource;
    }*/
}
