package cn.chenzw.spring.cloud.basic.security.authorization.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * 开启授权服务器
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final static String RESOURCE_ID = "user";

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置一个客户端（既可以通过授权码类型获取令牌，也可以通过密码类型获取令牌）
        // 此处使用内存客户端(可以配置在数据库、Redis中)
        clients.inMemory().withClient("client")  // 客户端ID
                .authorizedGrantTypes("authorization_code", "password", "refresh_code") // 客户端可以使用的授权类型
                .scopes("all")  // 允许请求范围
                .secret("secret")  // 客户端密钥（防止泄露）
                .redirectUris("http://localhost:8888/");  // 回调地址
    }

    /**
     * 配置AuthorizationService
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new InMemoryTokenStore())  // token保存在内存中(其它可选: JdbcTokenStore、RedisTokenStore)
                .accessTokenConverter(accessTokenConverter())  // 使用JWT作为令牌的转换器
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许所有人请求令牌
        // 已验证的客户端才能请求check_token端点
        security.tokenKeyAccess("premitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 配置JWT转换器
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("secret");
        return converter;
    }
}
