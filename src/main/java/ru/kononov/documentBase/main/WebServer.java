package ru.kononov.documentBase.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Класс для запуска Jetty
 */
@Configuration
@ComponentScan("ru.kononov.documentBase")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class WebServer  {

    private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private boolean hibernateShowSql;
    @Value("${spring.jpa.properties.hibernate.enable_lazy_load_no_trans}")
    private boolean hibernateEnableLazyLoadNoTrans;
    @Value("${spring.jpa.properties.hibernate.max_fetch_depth}")
    private int hibernateMaxFetchDepth;
    @Value("${spring.jpa.properties.hibernate.jdbc.fetch_size}")
    private int hibernateJdbcFetchSize;
    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int hibernateJdbcBathSize;

    public static void main (String[] args) {
        if (args.length == 1){
            try {
                int port = Integer.parseInt(args[0]);
                System.setProperty("server.port", String.valueOf(port));
                SpringApplication.run(WebServer.class, args);
            } catch (NumberFormatException e) {
                LOGGER.error("Номер порта должен иметь целочисленное значение");
            }
        } else if (args.length > 1)
            LOGGER.error("Для запуска приложения необходимо ввести не более одного параметра");
        else
            SpringApplication.run(WebServer.class);
    }

    @Bean
    @ConfigurationProperties
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().build();
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ru.kononov.documentBase.entities");
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.enable_lazy_load_no_trans", hibernateEnableLazyLoadNoTrans);
        properties.put("hibernate.max_fetch_depth", hibernateMaxFetchDepth);
        properties.put("hibernate.jdbc.fetch_size", hibernateJdbcFetchSize);
        properties.put("hibernate.jdbc.batch_size", hibernateJdbcBathSize);
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }

    @Bean
    @Autowired
    HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public Filter loggingFilter(){
        AbstractRequestLoggingFilter filter = new AbstractRequestLoggingFilter() {
            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                LOGGER.debug("before request: {}", message);
            }
            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                LOGGER.debug("after request: {}", message);
            }
        };
        filter.setIncludeClientInfo(true);
        filter.setIncludePayload(true);
        filter.setIncludeQueryString(true);
        return filter;
    }
}