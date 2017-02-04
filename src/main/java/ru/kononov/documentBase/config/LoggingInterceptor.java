package ru.kononov.documentBase.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 20.10.2016.
 */
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOGGER.debug("PRE_HANDLE \ntype: {} \n{} \nparameters: {} \nhandler: {}", request.getMethod(), request.getRequestURL(), request.getParameterMap(), handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.debug("POST_HANDLE \nresponse status: {} \n{}", response.getStatus(), response.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        LOGGER.debug("AFTER_COMPLETION \nresponse status: {} \n{}", response.getStatus(), response.toString());
    }
}