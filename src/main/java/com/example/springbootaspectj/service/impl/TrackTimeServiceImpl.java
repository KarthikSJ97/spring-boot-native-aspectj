package com.example.springbootaspectj.service.impl;

import com.example.springbootaspectj.service.TrackTimeService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Slf4j
@Aspect
public class TrackTimeServiceImpl implements TrackTimeService {

    public static final String NESTED_METHOD_NAME = "nestedMethod";
    public static final String PRIVATE_METHOD_NAME = "privateMethod";

    @Pointcut("execution(* *(..))")
    public void methodsToBeProfiled(){

    }

    @Override
    @Around("methodsToBeProfiled() && @annotation(com.example.springbootaspectj.utility.TrackTime)")
    public void audit(ProceedingJoinPoint joinPoint) throws Throwable {
        //Business logic
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long stopTime = System.currentTimeMillis();
        long executionTime = stopTime - startTime;
        log.info("Execution time of {}(): {} ms", method.getName(), executionTime);

        isNestedMethodIntercepted(method);
        isPrivateMethodIntercepted(method);
    }

    private void isNestedMethodIntercepted(Method method) {
        if(NESTED_METHOD_NAME.equals(method.getName())) {
            log.info("Nested method intercepted successfully !!");
        }
    }

    private void isPrivateMethodIntercepted(Method method) {
        if(PRIVATE_METHOD_NAME.equals(method.getName())) {
            log.info("Private method intercepted successfully !!");
        }
    }

}
