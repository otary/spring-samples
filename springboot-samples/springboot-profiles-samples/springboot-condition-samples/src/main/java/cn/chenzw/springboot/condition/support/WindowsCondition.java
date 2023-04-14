package cn.chenzw.springboot.condition.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Windows环境
 */
@Slf4j
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取的是当前Condition作用的bean上的注解
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(Bean.class.getName());

        log.info("context => {}", context);
        log.info("metadata => {}", metadata);
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
