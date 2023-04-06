package cn.chenzw.springcloud.basic.gateway.support.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 用户鉴权
 *
 * @author chenzw
 */
public class AuthFilter implements GatewayFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = null;
        HttpCookie tokenCookie = exchange.getRequest().getCookies().getFirst("token");
        if (tokenCookie != null) {
            token = tokenCookie.getValue();
        }
        // 拿到token判断是否已经登录
        if (!isLogin(token)) {
            // 如果没有登录则重定向都登录页面
            exchange.getResponse().setStatusCode(HttpStatus.FOUND);
            exchange.getResponse().getHeaders().set("Location", "/login");
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);

    }

    private boolean isLogin(String token) {
        return false;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
