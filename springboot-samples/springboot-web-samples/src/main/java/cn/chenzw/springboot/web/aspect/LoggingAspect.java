package cn.chenzw.springboot.web.aspect;

import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 日志切面示例
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    private ThreadLocal<JoinPointWrapper> joinPointWrapperTL = new ThreadLocal<>();

    private static final String POINT_CUT = "log()";

    @Pointcut("execution(public * cn.chenzw.springboot..*.* (..))")
    public void log() {
    }


    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) throws IOException {
        /*
        JoinPointWrapper joinPointWrapper = new JoinPointWrapper(joinPoint);
        joinPointWrapperTL.set(joinPointWrapper);

        logger.info("methodName:" + joinPointWrapper.getMethodName());
        logger.info("articleId:" + joinPointWrapper.getArtifactId());
        logger.info("bodyString:" + joinPointWrapper.getBodyString());
        logger.info("canonicalClassMethod:" + joinPointWrapper.getCanonicalClassMethod());
        logger.info("clientIp:" + joinPointWrapper.getClientIp());
        logger.info("httpMethod:" + joinPointWrapper.getHttpMethod());
        logger.info("queryString:" + joinPointWrapper.getQueryString());
        logger.info("threadName:" + joinPointWrapper.getThreadName());
        logger.info("uri:" + joinPointWrapper.getURI());
        logger.info("methodArgs:" + Arrays.toString(joinPointWrapper.getMethodArgs()));
        logger.info("threadId:" + joinPointWrapper.getThreadId());
        */
    }
}
