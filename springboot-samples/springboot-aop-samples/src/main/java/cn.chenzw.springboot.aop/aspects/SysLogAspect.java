package cn.chenzw.springboot.aop.aspects;

import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类(单例)
 */
@Aspect
@Component
public class SysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
    private static final String POINT_CUT = "sysLog()";

    private JoinPointWrapper joinPointWrapper = null;

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("@annotation(cn.chenzw.springboot.aop.support.SysLog)")
    public void sysLog() {

    }

    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        joinPointWrapper = new JoinPointWrapper(joinPoint);

        logger.info("AOP线程Id => {}", Thread.currentThread().getId());  // AOP共用主线程
        logger.info("URL : {}", joinPointWrapper.getURI());
        logger.info("HTTP_METHOD : {} ", joinPointWrapper.getHttpMethod());
        logger.info("IP : {}", joinPointWrapper.getClientIp());
        logger.info("CLASS_METHOD : {}", joinPointWrapper.getCanonicalClassMethod());
        logger.info("METHOD_ARGS : {}", Arrays.toString(joinPointWrapper.getMethodArgs()));
        logger.info("AOP @SysLog before => {}", joinPoint.getSignature().getName());

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        String[] parameterNames = discoverer.getParameterNames(methodSignature.getMethod());
        logger.info("param names => {}", parameterNames);

        // EL表达式提取值
        EvaluationContext context = new StandardEvaluationContext();
        JoinPointWrapper.ParamMeta[] methodArgs = joinPointWrapper.getMethodArgs();
        for (JoinPointWrapper.ParamMeta methodArg : methodArgs) {
            context.setVariable(methodArg.getName(), methodArg.getValue());
        }
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#userId");  // 提取userId参数
        Object userId = expression.getValue(context);
        logger.info("userId => {}", userId);

    }

    /**
     * 无论是否抛出异常，都会被执行到
     *
     * @param joinPoint
     */
    @After(POINT_CUT)
    public void after(JoinPoint joinPoint) {
        logger.info("AOP @SysLog after => {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = POINT_CUT, returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        logger.info("AOP @SysLog after returning => {}", joinPoint.getSignature().getName(), ret);
    }

    @AfterThrowing(pointcut = POINT_CUT, throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.info("AOP @SysLog after throwing => {}", joinPoint.getSignature().getName(),
                ex.getMessage());
    }

}
