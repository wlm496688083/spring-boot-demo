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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.mapper.two", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class RepositoryTwoConfig {

    @Autowired
    DruidDataSourceBase dataSourceBase;

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
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
        bean.setTypeAliasesPackage("com.example.domain");
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
