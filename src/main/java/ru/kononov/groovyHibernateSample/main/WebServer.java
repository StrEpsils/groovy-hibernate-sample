package ru.kononov.groovyHibernateSample.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Класс для запуска Jersey
 */
@Configuration
@ComponentScan("ru.kononov.groovyHibernateSample")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class WebServer  {

    private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    private static final String CONTEXT_PATH = "/groovy-hibernate-sample-web";

    public static void main (String[] args) {
        System.setProperty("server.contextPath", CONTEXT_PATH);
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
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("classpath:/data/hsqldb/structure.sql").addScript("classpath:/data/hsqldb/insert.sql")
                .setSeparator(";").build();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.kononov.groovyHibernateSample.entities");
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.enable_lazy_load_no_trans", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.fetch_size", 50);
        properties.put("hibernate.jdbc.batch_size", 10);
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }
}