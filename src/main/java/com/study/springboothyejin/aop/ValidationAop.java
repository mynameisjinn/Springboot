package com.study.springboothyejin.aop;

import com.study.springboothyejin.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboothyejin.web.controller.account.AccountApiController.*(..))")
    private  void executionPointCut() {};

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("AOP 작동함");

        BeanPropertyBindingResult bindingResult = null;
        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }
        if(bindingResult != null){
            if(bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<String, String>();
                bindingResult.getFieldErrors().forEach(error ->{
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }
        Object returnValue = proceedingJoinPoint.proceed();

        return returnValue;
    }
}
