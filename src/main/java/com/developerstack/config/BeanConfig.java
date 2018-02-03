package com.developerstack.config;

import com.developerstack.controller.AppErrorController;
import com.developerstack.service.impl.UserDetailServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.developerstack")
public class BeanConfig {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.developerstack.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

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

    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }
}
