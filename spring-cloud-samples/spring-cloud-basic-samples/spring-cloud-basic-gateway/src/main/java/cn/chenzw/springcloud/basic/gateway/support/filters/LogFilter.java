package cn.chenzw.springcloud.basic.gateway.support.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 日志记录
 * @author chenzw
 */
@Slf4j
public class LogFilter implements GatewayFilter, Ordered {

    private static final String START_TIME = "startTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 过滤器前置执行
        String url = exchange.getRequest().getURI().getRawPath();
        log.info("请求地址 => {}， 入参 => {}", url, exchange.getRequest().getQueryParams().toString());
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());

        // chain.filter里面的逻辑相当于后过滤器post filter
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(START_TIME);
                    if (startTime != null) {
                        log.info("请求 {} 耗时 => {}ms", url, System.currentTimeMillis() - startTime);
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
