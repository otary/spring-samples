package cn.chenzw.spring.annotation.aware.config;

import cn.chenzw.spring.annotation.aware.bean.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public App appBean() {
        return new App();
    }
}
