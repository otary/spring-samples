package cn.chenzw.springboot.mybatis.plus.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.**.repository"})
public class MybatisConfig {


}
