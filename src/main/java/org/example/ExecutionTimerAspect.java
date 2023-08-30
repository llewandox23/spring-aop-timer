package org.example;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimerAspect {

    Logger LOG = LoggerFactory.getLogger(ExecutionTimerAspect.class);
    @Around("@annotation(org.example.ExecutionTimer)")
    public Object executionTime(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            long startTime = System.currentTimeMillis();
            proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - startTime;
            LOG.info("Execution time is {} milliseconds for {}" , executionTime, joinPoint.getSignature());
        } catch (Throwable e) {
            LOG.error("error", e);
        }
        return proceed;
    }

}
