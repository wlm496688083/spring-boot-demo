package com.example.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.example.mapper.two", sqlSessionTemplateRef = "sqlSessionTemplate2")
//@EnableConfigurationProperties(MybatisProperties.class)
public class RepositoryTwoConfig {

    private MybatisProperties properties;

    private DruidDataSourceBase dataSourceBase;

    public RepositoryTwoConfig(MybatisProperties properties, DruidDataSourceBase dataSourceBase) {
        this.properties = properties;
        this.dataSourceBase = dataSourceBase;
    }
    @Bean(name = "dataSource2")
    public DruidDataSource dataSource2() {
        return dataSourceBase.getDruidDataSource(dataSourceProperties2());
    }

    @Bean(name = "dataSourceProperties2")
    @ConfigurationProperties(prefix = "datasource.2")
    public DataSourceProperties dataSourceProperties2() {
        return new DataSourceProperties();
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(this.properties.resolveMapperLocations());
        factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        return factory.getObject();
    }

    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
