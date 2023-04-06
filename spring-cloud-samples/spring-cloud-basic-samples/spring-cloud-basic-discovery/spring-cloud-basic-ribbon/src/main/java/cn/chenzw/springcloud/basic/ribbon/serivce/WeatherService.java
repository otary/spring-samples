package cn.chenzw.springcloud.basic.ribbon.serivce;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 使用restTemplate远程调用
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "handlerException")
    public String today() {
        return restTemplate.getForObject("http://SPRING-CLOUD-BASIC-EUREKA-CLIENT/weathers/today", String.class);
    }

    public String handlerException() {
        return "请求异常,断路由熔断！";
    }

}
