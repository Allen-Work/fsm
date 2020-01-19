package com.gtstar.fsm.config;/*
package com.gtstar.com.gtstar.fsm.config;

import com.gtstar.com.gtstar.fsm.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

*/
/**
 * @ClassName FilterConfig
 * @Description TODO
 * @Author yuxiang
 * @Date 2020/1/15 10:40
 **//*

@Configuration
public class FilterConfig {
    @Bean
    public Filter myFilter() {
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter((MyFilter) myFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.setOrder();多个filter的时候,order数值越小优先级越高
        return filterRegistrationBean;
    }
}
*/
