package com.lotusphere.user_management;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
// @Slf4j: This is a Lombok annotation that generates a logger instance for the class. SLF4J stands for Simple Logging Facade for Java. It is a facade for various logging frameworks (e.g., Java Util Logging, Logback, Log4j). It allows the end-user to plug in the desired logging framework at deployment time.
@Component
// @Component: This makes the LogInterceptor a Spring-managed bean, allowing it to be injected where needed.
public class LogInterceptor implements HandlerInterceptor {
    // LogInterceptor is a Spring MVC interceptor that will intercept HTTP requests and responses.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // return HandlerInterceptor.super.preHandle(request, response, handler);
        log.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        log.info("afterCompletion");
    }
}
