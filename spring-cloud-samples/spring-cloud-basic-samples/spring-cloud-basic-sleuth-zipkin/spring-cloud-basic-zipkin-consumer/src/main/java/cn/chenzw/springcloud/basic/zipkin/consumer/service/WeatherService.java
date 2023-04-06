package cn.chenzw.springcloud.basic.zipkin.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用远程接口
     *
     * @return
     */
    public String today() {
        return restTemplate.getForObject("http://localhost:8988/weathers/today", String.class);
    }


}
