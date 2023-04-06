package cn.chenzw.spring.cloud.basic.security.authorization.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存中配置2个用户（用于测试）
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // 创建用户: user_authorization_code - 123456
        userDetailsManager.createUser(User.withUsername("chenzw")
                .password("123456")
                .authorities("USER")
                .build());

        userDetailsManager.createUser(User.withUsername("admin")
                .password("123456")
                .authorities("USER")
                .build());
        auth.userDetailsService(userDetailsManager);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        return authenticationManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 允许访问/oauth授权接口
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers()
                .anyRequest()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*")
                .permitAll();
    }

    /**
     * 配置密码解码器（密码加密、解密）
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
