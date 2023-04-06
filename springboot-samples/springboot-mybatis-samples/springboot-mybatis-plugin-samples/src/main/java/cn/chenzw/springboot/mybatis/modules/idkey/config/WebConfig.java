package cn.chenzw.springboot.mybatis.modules.idkey.config;

import cn.chenzw.springboot.mybatis.modules.idkey.support.CustIdGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    /**
     * 自定义ID生成器
     *
     * @return
     */
    @Bean
    public IdentifierGenerator custIdGenerator() {
        return new CustIdGenerator();
    }

}
