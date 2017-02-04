package ru.kononov.documentBase.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by admin on 21.10.2016.
 */

@Configuration
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class PersistanceConfig {

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private boolean hibernateShowSql;
    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private boolean hibernateFormatSql;
    @Value("${spring.jpa.properties.hibernate.enable_lazy_load_no_trans}")
    private boolean hibernateEnableLazyLoadNoTrans;
    @Value("${spring.jpa.properties.hibernate.max_fetch_depth}")
    private int hibernateMaxFetchDepth;
    @Value("${spring.jpa.properties.hibernate.jdbc.fetch_size}")
    private int hibernateJdbcFetchSize;
    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int hibernateJdbcBathSize;

    @Bean
    @ConfigurationProperties
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().build();
    }

    @Bean
    @Autowired
    @ConfigurationProperties
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("ru.kononov.documentBase.entities");
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.format_sql", hibernateFormatSql);
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
}
