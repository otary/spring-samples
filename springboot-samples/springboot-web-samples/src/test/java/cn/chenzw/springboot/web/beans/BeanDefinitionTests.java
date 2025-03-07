package cn.chenzw.springboot.web.beans;

import cn.chenzw.springboot.web.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanDefinitionTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void testCreateBean() {
        // 创建Bean
        UserDTO bean = context.getAutowireCapableBeanFactory().createBean(UserDTO.class);

        log.info("bean => {}", bean);
    }

    @Test
    public void testRegisterBeanDefinition() {
        // 注册Bean
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context;

        // 构建BeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(UserDTO.class);

        // 传入构建函数参数
        ConstructorArgumentValues constructorArgumentValues = rootBeanDefinition.getConstructorArgumentValues();
        constructorArgumentValues.addGenericArgumentValue("1");
        constructorArgumentValues.addGenericArgumentValue("张三");
        constructorArgumentValues.addGenericArgumentValue("20");

        rootBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        // 可以放一些额外的属性
        rootBeanDefinition.getPropertyValues().add("xxx", "yyy");

        registry.registerBeanDefinition("userDto", rootBeanDefinition);

        log.info("userDto => {}", context.getBean("userDto"));
    }
}
