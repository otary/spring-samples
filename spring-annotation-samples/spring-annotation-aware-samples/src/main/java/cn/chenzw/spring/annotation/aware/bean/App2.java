package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 *
 */
public class App2 implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessBeforeInstantiation]:" + aClass + "," + s);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessAfterInstantiation]:" + o + "," + s);
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessPropertyValues]:" + propertyValues + "," + o + "," + s);
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessBeforeInitialization]:" + o + "," + s);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("--- InstantiationAwareBeanPostProcessor[postProcessAfterInitialization]:" + o + "," + s);
        return null;
    }
}
