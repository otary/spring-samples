package cn.chenzw.spring.xml.schema.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标识被扫描的类
 * @author chenzw
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SSO {

    /**
     * 来源系统
     * @return
     */
    String[] source();
}
