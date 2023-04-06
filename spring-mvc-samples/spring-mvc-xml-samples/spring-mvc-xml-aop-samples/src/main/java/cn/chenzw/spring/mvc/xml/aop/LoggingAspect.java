package cn.chenzw.spring.mvc.xml.aop;

import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private ThreadLocal<JoinPointWrapper> joinPointWrapperTL = new ThreadLocal<>();

    private static final String POINT_CUT = "log()";

    @Pointcut("execution(* cn.chenzw.spring.mvc..*.* (..))")
    public void log() {
    }


    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) throws IOException {

        JoinPointWrapper joinPointWrapper = new JoinPointWrapper(joinPoint);
        joinPointWrapperTL.set(joinPointWrapper);

        System.out.println("methodName:" + joinPointWrapper.getMethodName());
        System.out.println("articleId:" + joinPointWrapper.getArtifactId());
        System.out.println("bodyString:" + joinPointWrapper.getBodyString());
        System.out.println("canonicalClassMethod:" + joinPointWrapper.getCanonicalClassMethod());
        System.out.println("clientIp:" + joinPointWrapper.getClientIp());
        System.out.println("httpMethod:" + joinPointWrapper.getHttpMethod());
        System.out.println("queryString:" + joinPointWrapper.getQueryString());
        System.out.println("threadName:" + joinPointWrapper.getThreadName());
        System.out.println("uri:" + joinPointWrapper.getURI());
        System.out.println("methodArgs:" + Arrays.toString(joinPointWrapper.getMethodArgs()));
        System.out.println("threadId:" + joinPointWrapper.getThreadId());

    }


}
