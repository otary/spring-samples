package cn.chenzw.spring.mvc.context.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.chenzw.spring.mvc.context"})
public class WebConfig {

}
