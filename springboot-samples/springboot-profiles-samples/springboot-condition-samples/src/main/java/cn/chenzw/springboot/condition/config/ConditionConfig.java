package cn.chenzw.springboot.condition.config;

import cn.chenzw.springboot.condition.bean.HelloBean;
import cn.chenzw.springboot.condition.bean.MyBean;
import cn.chenzw.springboot.condition.support.LinuxCondition;
import cn.chenzw.springboot.condition.support.WindowsCondition;
import cn.chenzw.springboot.condition.template.AbstractTemplate;
import cn.chenzw.springboot.condition.template.LinuxTemplate;
import cn.chenzw.springboot.condition.template.WindowsTemplate;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 自定义条件 - 满足WindowsCondition条件，则实例化此bean
     *
     * @return
     */
    @Bean
    @Conditional({WindowsCondition.class})
    public AbstractTemplate windowsTemplate() {
        return new WindowsTemplate();
    }

    /**
     * 自定义条件 - 满足LinuxCondition条件，则实例化此bean
     *
     * @return
     */
    @Bean
    @Conditional({LinuxCondition.class})
    public AbstractTemplate linuxTemplate() {
        return new LinuxTemplate();
    }


    /**
     * 当HelloBean类存在时才实例化此Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnClass({HelloBean.class})
    public MyBean myBean() {
        return new MyBean();
    }


    @Bean
    @ConditionalOnBean(name = {"myBean"}, value = MyBean.class)
    public MyBean myBean_1() {
        return new MyBean();
    }


    @Bean
    HelloBean helloBean() {
        return new HelloBean();
    }

    /**
     * 当存在HelloBean单例时，才实例化此Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnSingleCandidate(HelloBean.class)
    public MyBean myBean2() {
        return new MyBean();
    }


    /**
     * 基于SpEL表达式作为判断条件
     *
     * @return
     */
    @Bean
    // @ConditionalOnExpression("")
    public MyBean myBean3() {
        return new MyBean();
    }


    /**
     * 基于JDK版本作为判断条件（Java版本 > 8）
     *
     * @return
     */
    @Bean
    @ConditionalOnJava(range = ConditionalOnJava.Range.EQUAL_OR_NEWER, value = JavaVersion.EIGHT)
    public MyBean myBean4() {
        return new MyBean();
    }

    /**
     * 有指定的属性值时生效
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "my.name", havingValue = "chenzw", matchIfMissing = false)
    public MyBean myBean5() {
        return new MyBean();
    }

    /**
     * 有指定的资源文件时生效
     *
     * @return
     */
    @Bean
    @ConditionalOnResource(resources = {"classpath:application.yml"})
    public MyBean myBean6() {
        return new MyBean();
    }

    /**
     * 缺少指定过滤器时生效
     * 不生效？
     *
     * @return
     */
    @Bean
    //  @ConditionalOnMissingFilterBean(CommonsRequestLoggingFilter.class)
    public MyBean myBean7() {
        return new MyBean();
    }


    /**
     * WebApplication环境下才生效
     * @return
     */
    @Bean
    @ConditionalOnWebApplication
    public MyBean myBean8() {
        return new MyBean();
    }

}
