package cn.chenzw.springcloud.basic.gateway.support.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 黑名单
 */
public class BlackFilter implements GatewayFilter, Ordered {

    // 黑名单列表，也可以放在缓存数据库里
    List<String> blackList = Arrays.asList("1111", "2222");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 用户id
        String id = exchange.getRequest().getHeaders().getFirst("uid");
        if (blackList.contains(id)) {
            // 如果是黑名单就直接返回，不再往目标服务器转发
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
