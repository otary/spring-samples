package cn.chenzw.springcloud.basic.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

/**
 * 断路由
 */
@Component
public class WeatherServiceHystrix implements WeatherService {

    @Override
    public String todayFromClient() {
        return "请求异常,断路由熔断！";
    }

    @Override
    public String todayWithHeader(String token) {
        return null;
    }

    @Override
    public String todayWithHeaders(MultiValueMap<String, String> headers) {
        return null;
    }

    @Override
    public String todayWidthFixedHeader() {
        return null;
    }
}
