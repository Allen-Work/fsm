package com.gtstar.fsm.service.impl;/*
package com.gtstar.com.gtstar.fsm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @ClassName MyInterceptor
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/14 16:30
 **//*

@Service
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("MyInterceptor preHandle...");
        String contextPath = request.getContextPath();
        String matchValue = request.getHttpServletMapping().getMatchValue();
        String serverName = request.getServerName();
        String pathInfo = request.getPathInfo();
        String url = request.getRequestURL().toString();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("MyInterceptor postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("MyInterceptor afterCompletion...");
    }
}
*/
