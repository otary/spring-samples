package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 *
 */
public class AppForProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessBeforeInstantiation]:" + beanClass + ","
                + beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println(
                "--- InstantiationAwareBeanPostProcessor[postProcessAfterInstantiation]:" + bean + "," + beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues,
            PropertyDescriptor[] propertyDescriptors, Object bean, String beanName) throws BeansException {
        System.out.println(
                "--- InstantiationAwareBeanPostProcessor[postProcessPropertyValues]:" + propertyValues + "," + bean
                        + "," + beanName);
        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(
                "--- InstantiationAwareBeanPostProcessor[postProcessBeforeInitialization]:" + bean + "," + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(
                "--- InstantiationAwareBeanPostProcessor[postProcessAfterInitialization]:" + bean + "," + beanName);
        return bean;
    }
}
