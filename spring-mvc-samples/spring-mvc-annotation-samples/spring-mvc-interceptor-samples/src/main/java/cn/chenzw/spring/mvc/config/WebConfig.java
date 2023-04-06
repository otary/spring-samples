package cn.chenzw.spring.mvc.config;

import cn.chenzw.spring.mvc.interceptor.Samples2HandlerInterceptor;
import cn.chenzw.spring.mvc.interceptor.SamplesHandlerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.chenzw.spring.mvc"})
public class WebConfig extends WebMvcConfigurerAdapter {


    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SamplesHandlerInterceptor());
        registry.addInterceptor(new Samples2HandlerInterceptor());
    }




}
