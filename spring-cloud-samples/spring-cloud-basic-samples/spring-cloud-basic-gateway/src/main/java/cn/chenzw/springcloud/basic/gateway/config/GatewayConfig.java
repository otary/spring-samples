package cn.chenzw.springcloud.basic.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GatewayConfig {

    /**
     * 基于路径的断言匹配
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> pathRoute1() {
        RouterFunction<ServerResponse> router = RouterFunctions.route(
                RequestPredicates.path("/path/result"),
                serverRequest -> ServerResponse.ok().body(BodyInserters.fromObject("hello"))
        );
        return router;
    }

    /**
     * 基于路径的断言匹配2
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator pathRoute2(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route_test", r ->
                r.path("/path/route/test")
                        .uri("https://www.baidu.com")
        ).build();
    }

    /**
     * 基于Host匹配转发
     *
     * @return
     */
    @Bean
    public RouteLocator hostRoute(RouteLocatorBuilder builder) {
        return builder.routes().route(r ->
                r.host("**.chenzw.cn")
                        .uri("https://www.chenzw.cn")
                        .order(1)
                        .id("host_route_test")
        ).build();
    }

}
