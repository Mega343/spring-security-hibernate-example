package com.developerstack.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.developerstack")
public class DataBaseConfig {


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.developerstack"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(
//            SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//                sessionFactory);
//
//        return transactionManager;
//    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/medrec");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "create");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
                setProperty("hibernate.connection.CharSet", "utf8");
                setProperty("hibernate.connection.characterEncoding", "utf8");
                setProperty("hibernate.connection.useUnicode", "true");
                // setProperty("hibernate.hbm2ddl.import_files", "data.sql");
            }
        };
    }
}