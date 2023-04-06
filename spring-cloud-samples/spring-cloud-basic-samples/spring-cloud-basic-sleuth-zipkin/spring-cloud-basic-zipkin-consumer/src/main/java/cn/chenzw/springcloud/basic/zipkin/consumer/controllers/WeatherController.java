package cn.chenzw.springcloud.basic.zipkin.consumer.controllers;

import cn.chenzw.springcloud.basic.zipkin.consumer.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/today")
    public String today() {
        return weatherService.today();
    }
}
