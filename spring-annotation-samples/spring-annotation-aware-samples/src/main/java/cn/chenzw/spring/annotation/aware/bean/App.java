package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class App implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, MessageSourceAware, ApplicationEventPublisher, ResourceLoaderAware, ServletContextAware {

    /**
     * 获取容器
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("- BeanFactoryAware:" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("- BeanNameAware:" + name);
    }

    /**
     * 获取容器
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("- ApplicationContextAware:" + applicationContext);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        System.out.println("- ApplicationEventPublisher:" + event);
    }

    @Override
    public void publishEvent(Object event) {
        System.out.println("- ApplicationEventPublisher:" + event);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("- MessageSourceAware:" + messageSource);
    }

    /**
     * 可用于加载资源文件
     *
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("- ResourceLoaderAware:" + resourceLoader);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("- ServletContextAware:" + servletContext);
    }


}
