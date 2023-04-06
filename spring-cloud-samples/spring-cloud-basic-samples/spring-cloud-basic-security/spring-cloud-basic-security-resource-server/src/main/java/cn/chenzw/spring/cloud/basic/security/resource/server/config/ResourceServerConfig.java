package cn.chenzw.spring.cloud.basic.security.resource.server.config;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 开启资源服务器
 */
@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .tokenStore(new JwtTokenStore(accessTokenConverter()))
                .stateless(true);

        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setAccessTokenConverter(accessTokenConverter());

        RestTemplate restTemplate = restTemplate();
        // 为restTemplate配置异常处理器，忽略400错误
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
        tokenServices.setRestTemplate(restTemplate);
        tokenServices.setCheckTokenEndpointUrl("http://AUTHORIZATION-SERVER/oauth/check_token");  // 通过授权服务器的/oauth/check_token端点对令牌进行解析
        tokenServices.setClientId("client");
        tokenServices.setClientSecret("secret");  // 服务器密钥
        resources.tokenServices(tokenServices).stateless(true);
    }

    // 配置JWT转换器，用于对令牌解析认证
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("secret");
        return converter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 配置资源服务器的拦截规则（令牌解析出信息后进行权限认证）
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers().anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated() // /user/** 端点的访问必须要验证后
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}