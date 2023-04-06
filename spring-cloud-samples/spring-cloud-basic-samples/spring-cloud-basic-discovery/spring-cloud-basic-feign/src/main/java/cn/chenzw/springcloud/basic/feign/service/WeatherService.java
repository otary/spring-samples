package cn.chenzw.springcloud.basic.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Feign客户端
 *
 * @author chenzw
 */
@FeignClient(value = "SPRING-CLOUD-BASIC-EUREKA-CLIENT", url = "", fallback = WeatherServiceHystrix.class)
public interface WeatherService {

    @GetMapping(value = "/weathers/today")
    String todayFromClient();


    /**
     * 带单个动态header
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/weathers/today")
    String todayWithHeader(@RequestHeader("token") String token);

    /**
     * 带多个动态header
     *
     * @param headers
     * @return
     */
    @GetMapping(value = "/weathers/today")
    String todayWithHeaders(@RequestHeader MultiValueMap<String, String> headers);

    /**
     * 带固定header
     *
     * @return
     */
    @GetMapping(value = "/weathers/today", headers = {"Content-Type=application/json;charset=UTF-8"})
    String todayWidthFixedHeader();

}
