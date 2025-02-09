package cn.chenzw.springboot.satoken.configuration;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.dao.SaTokenDaoRedis;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SaTokenDaoConfig {

    @Bean
    public SaTokenDao saTokenDao() {
        return new SaTokenDaoRedis();
    }
}
