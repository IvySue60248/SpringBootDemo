package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用@Aspect声明是一个切面
 * 使用@After @Before @Around 定义建言，可以直接将拦截规则（切点PointCut）作为参数
 * 为了使切点复用，可使用@PointCut专门定义拦截规则，然后在@After @Before的参数中调用
 * 符合条件的每一个被拦截处就是一个连接点（JoinPoint）
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)")
    public void annotationPointCut(){}

    /*
    此处@After使用@PointCut定义的切点
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name() );
    }

    /*
    此处@Before直接使用拦截规则作为参数
     */
    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截 " + method.getName());
    }
}
