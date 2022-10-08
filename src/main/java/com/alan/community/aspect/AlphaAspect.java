package com.alan.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/8 15:50
 */
@Component
@Aspect
public class AlphaAspect {

    @Pointcut("execution(* com.alan.community.service.*.*(..))")
    public void pointcut(){
    }

    // 连接点开头执行
    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }

    // 连接点后面执行
    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    // 有返回值之后执行
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    // 抛异常执行
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    // 方法执行前后执行
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before");
        Object obj = joinPoint.proceed();
        System.out.println("around after");
        return obj;
    }
}
