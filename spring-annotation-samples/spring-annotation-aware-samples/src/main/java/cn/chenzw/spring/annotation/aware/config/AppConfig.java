package cn.chenzw.spring.annotation.aware.config;

import cn.chenzw.spring.annotation.aware.bean.*;
import cn.chenzw.spring.annotation.aware.bean.event.*;
import cn.chenzw.spring.annotation.aware.lifecycle.CustomSmartLifeStyle;
import org.springframework.context.ApplicationListener;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AppForAware appBean() {
        return new AppForAware();
    }

    @Bean
    public AppForProcessor appBean2() {
        return new AppForProcessor();
    }

    @Bean
    public AppForListener appBean3() {
        return new AppForListener();
    }

    @Bean
    public ApplicationListener contextRefreshedEventListener() {
        return new ContextRefreshedEventListener();
    }

    @Bean
    public ApplicationListener contextStartedEventListener() {
        return new ContextStartedEventListener();
    }

    @Bean
    public ApplicationListener contextClosedEventListener() {
        return new ContextClosedEventListener();
    }

    @Bean
    public ApplicationListener contextStoppedEventListener() {
        return new ContextStoppedEventListener();
    }

    @Bean
    public ApplicationListener requestHandledEventListener() {
        return new RequestHandledEventListener();
    }

    @Bean
    public Lifecycle customSmartLifeStyle() {
        return new CustomSmartLifeStyle();
    }

    @Bean
    public AppForInitializationBean appBean4() {
        return new AppForInitializationBean();
    }

    @Bean
    public AppForFactoryBean.MyBean appFactoryBean() throws Exception {
        return new AppForFactoryBean().getObject();
    }
}
