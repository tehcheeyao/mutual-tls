package com.tehcheeyao.mutualtls.middleware;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PlaintextLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PlaintextLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("--- Incoming secured Request ---");
        logger.info("Method: {}", request.getMethod());
        logger.info("URL: {}", request.getRequestURL());
        logger.info("Source IP: {}", request.getRemoteAddr());

        logger.info("User-Agent: {}", request.getHeader("User-Agent"));

        return true;
    }
}