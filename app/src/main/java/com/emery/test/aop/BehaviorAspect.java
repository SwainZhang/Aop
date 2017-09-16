package com.emery.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MyPC on 2017/1/29.
 *
 * aspect切面（确定切下什么面）
 */

@Aspect
public class BehaviorAspect {

    /*
        切点(如何切）   * *(..)  BehaviorInterface注解下的任何方法 任何参数，
     */
    @Pointcut("execution(@com.emery.test.aop.BehaviorInterface * *(..))")
    public void annoBehavior(){

    }

    /**
     * 处理切下来的切面
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("annoBehavior()")
    public Object dealPoint(ProceedingJoinPoint point) throws Throwable {

        //方法执行时
        MethodSignature signature = (MethodSignature) point.getSignature();
        BehaviorInterface annotation = signature.getMethod().getAnnotation(BehaviorInterface.class);
        String value = annotation.value();
       // System.out.println(value);

        System.out.println("------"+ new SimpleDateFormat().format(new Date())+"-----------");
        long begin=System.currentTimeMillis();
        //方法执行时
        Object proceed=null;
        try {
            proceed = point.proceed();
        }catch (Exception e){

        }

        //方法执行完成
        long end=begin-System.currentTimeMillis();
        System.out.println("------------共耗时"+end+"ms-------------");

        return proceed;

    }

}
