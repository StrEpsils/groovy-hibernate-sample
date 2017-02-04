package ru.kononov.documentBase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by admin on 12.01.2017.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="ru.kononov.documentBase.aspect")
public class AspectConfig {
}
