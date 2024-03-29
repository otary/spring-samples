package cn.chenzw.springboot.web.config;

import cn.chenzw.springboot.web.domain.dto.UserDTO;
import cn.chenzw.springboot.web.filter.ExceptionFilter;
import cn.chenzw.springboot.web.formatter.UserFormatter;
import cn.chenzw.springboot.web.repository.UserMapper;
import cn.chenzw.springboot.web.resolver.argument.ArrayMethodArgumentResolver;
import cn.chenzw.springboot.web.resolver.argument.RequestBase64ArgumentResolver;
import cn.chenzw.toolkit.spring.annotation.EnableToolkit;
import cn.chenzw.toolkit.spring.ratelimit.annotation.EnableRateLimit;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.List;


@Configuration
//@EnableWebMvc
@EnableToolkit
@EnableRateLimit
public class WebConfig implements WebMvcConfigurer {


    /*@Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return  multipartResolver;
    }*/

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ArrayMethodArgumentResolver());
        resolvers.add(new RequestBase64ArgumentResolver());
    }

    // @Autowired
    // UserMapper userMapper;

    /**
     * 字符串（id） => UserDto对象
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        UserMapper userMapper = id -> {
            UserDTO userDto = new UserDTO();
            userDto.setId(Long.valueOf(id));
            userDto.setName("王五");
            userDto.setAge("20");
            return userDto;
        };
        registry.addFormatter(new UserFormatter(userMapper));
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean =
                new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new ExceptionFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
