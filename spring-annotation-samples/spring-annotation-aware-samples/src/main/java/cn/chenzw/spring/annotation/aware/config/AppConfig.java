package cn.chenzw.spring.annotation.aware.config;

import cn.chenzw.spring.annotation.aware.bean.*;
import cn.chenzw.spring.annotation.aware.lifecycle.CustomSmartLifeStyle;
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
