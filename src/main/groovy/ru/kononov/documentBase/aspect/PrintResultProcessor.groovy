package ru.kononov.documentBase.aspect

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestParam

import java.lang.annotation.Annotation
import java.lang.reflect.Method;

/**
 * Created by admin on 12.01.2017.
 */
@Component
@Aspect
class PrintResultProcessor {

    @Around("@annotation(ru.kononov.documentBase.aspect.PrintResult)")
    public static Object fixEvent(ProceedingJoinPoint joinPoint) {
        Logger logger = LogManager.getLogger(joinPoint.target.class)
        logger.debug(joinPoint.proceed())
        joinPoint.proceed();
    }
}
