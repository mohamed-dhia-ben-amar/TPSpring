package com.example.testfinal.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Collection;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Around("execution( * com.example.testfinal.Conrollers.*.get*(..))")
    public Collection<Object> inMethodforGetAll(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Collection<Object> obj = (Collection<Object>) pjp.proceed();
        stopWatch.stop();

        log.info("execution time of {} is {} ", pjp.getSignature().getName(),stopWatch.getTotalTimeMillis() );
        return obj;
    }

}
