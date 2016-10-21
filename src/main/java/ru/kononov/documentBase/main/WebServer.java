package ru.kononov.documentBase.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Класс для запуска Jetty
 */
@ComponentScan("ru.kononov.documentBase")
@SpringBootApplication
public class WebServer {

    private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

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
}