package cn.chenzw.spring.annotation.aware.config;

import cn.chenzw.spring.annotation.aware.bean.App;
import cn.chenzw.spring.annotation.aware.bean.App2;
import cn.chenzw.spring.annotation.aware.lifecycle.CustomSmartLifeStyle;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public App appBean() {
        return new App();
    }

    @Bean
    public App2 appBean2() {
        return new App2();
    }

    @Bean
    public Lifecycle customSmartLifeStyle() {
        return new CustomSmartLifeStyle();
    }
}
