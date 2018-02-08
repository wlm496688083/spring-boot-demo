package com.example.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.mapper")
@EnableConfigurationProperties({MybatisProperties.class})
public class RepositoryOneConfig {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Autowired
    private MybatisProperties properties;

    @Bean(name = "dataSource1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory()
            throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource1());
        factory.setMapperLocations(this.properties.resolveMapperLocations());
        factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        return factory.getObject();
    }

   /* @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }*/

    @Bean("txManager1")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource1());
    }
}
