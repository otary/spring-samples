package cn.chenzw.springcloud.nacos.controller;

import cn.chenzw.springcloud.nacos.properties.AppProperties;
import cn.chenzw.springcloud.nacos.properties.UserProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动刷新配置
 */
@Slf4j
@RefreshScope  // => 用于@Value注解
@RestController
@RequestMapping("/dynamic-var")
public class DynamicVarController {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private Integer age;

    @Autowired
    UserProperties userProperties;

    @Autowired
    AppProperties appProperties;

    @GetMapping("/getName")
    public String getName() {
        return name + " => " + userProperties;
    }

    @GetMapping("/getAge")
    public Integer getAge() {
        return age;
    }

    @GetMapping("/getAppName")
    public String getAppName() {
        log.info("appProperties => {}", appProperties);

        return appProperties.getName();
    }


}
