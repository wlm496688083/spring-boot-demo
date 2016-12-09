package com.example.config;

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
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mapper.one", sqlSessionTemplateRef = "sqlSessionTemplate1")
@EnableConfigurationProperties(MybatisProperties.class)
public class RepositoryOneConfig {

    private MybatisProperties properties;

    private DruidDataSourceBase dataSourceBase;

    public RepositoryOneConfig(MybatisProperties properties, DruidDataSourceBase dataSourceBase) {
        this.properties = properties;
        this.dataSourceBase = dataSourceBase;
    }

    @Bean(name = "dataSource1")
    @Primary
    public DruidDataSource dataSource1() {
        return dataSourceBase.getDruidDataSource(dataSourceProperties1());
    }

    @Bean(name = "dataSourceProperties1")
    @ConfigurationProperties(prefix = "datasource.1")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }


    @Bean(name = "sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(this.properties.resolveMapperLocations());
        factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        return factory.getObject();
    }

    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
