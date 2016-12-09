package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mapper.one", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class RepositoryOneConfig {

    @Autowired
    DruidDataSourceBase dataSourceBase;

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
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
        bean.setTypeAliasesPackage("com.example.domain");
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
