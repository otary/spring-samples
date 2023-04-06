package cn.chenzw.springcloud.basic.zipkin.producer.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供服务
 *
 * @author chenzw
 */
@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @Value("${spring.application.name}")
    private String appName;

    /**
     * 对外提供接口
     *
     * @return
     */
    @GetMapping("/today")
    public String today() {
        return appName + ": [temperature: 25, humidity: 82, info: 阴, direct: 西北风, power: 3级]";
    }
}
