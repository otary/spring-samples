package cn.chenzw.springcloud.basic.gateway.config;

import cn.chenzw.springcloud.basic.gateway.support.filters.AuthFilter;
import cn.chenzw.springcloud.basic.gateway.support.filters.BlackFilter;
import cn.chenzw.springcloud.basic.gateway.support.filters.LogFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author chenzw
 */
@Configuration
public class GatewayFunctionsConfig {


    /**
     * 蓝绿发布
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator blueGreenRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                // 80%流量到老版本服务
                .route(p -> p.weight("oldGroup", 8).and().path("/search")
                        .uri("https://cn.bing.com"))
                // 20%流量到新版本服务
                .route(p -> p.weight("newGroup", 2).and().path("/search")
                        .filters(f -> f.stripPrefix(1))
                        .uri("https://www.baidu.com"))
                .build();
    }


    /**
     * 熔断
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> fallbackRoute() {
        // 请求 /fallback 时返回"请稍后再试"
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/fallback"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("请稍后再试!")));
        return route;
    }

    @Bean
    public RouteLocator hystrixRoute(RouteLocatorBuilder builder) {
        // header中带有error的都跳转到/fallback
        return builder.routes()
                .route(p -> p.header("error")
                        .filters(f -> f.hystrix((config -> config
                                .setName("myhystrix")
                                .setFallbackUri("forward:/fallback")))) // 熔断，如果访问报错则跳到/fallback

                        .uri("https://www.baidu.com"))
                .build();
    }


    /**
     * 黑名单
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator blackRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .uri("https://www.baidu.com").filters(new BlackFilter()))
                .build();
    }


    /**
     * 日志记录
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator logRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/log")
                        .uri("https://www.baidu.com")
                        .filter(new LogFilter())).build();
    }


    /**
     * 用户鉴权
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/login"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("请登录系统!")));
        return route;
    }

    @Bean
    public RouteLocator authRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/auth")
                        .filters(f -> f.filter(new AuthFilter()))
                        .uri("https://www.baidu.com"))
                .build();
    }


}
