package jp.hinagata.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(MethodInterceptor.class);

    @Pointcut("within(jp.hinagata..*)")
    public void methodPointcutTarget() {
    }

    @Around("methodPointcutTarget()")
    public Object MethodLog(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        // Starting time.
        stopWatch.start();

        logger.debug("START METHOD VALUE CLASS=[{}] METHOD=[{}] VALUE=[{}]",
                joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(),
                joinPoint.getArgs() != null ? Arrays.toString(joinPoint.getArgs()) : null);

        // Execute method.
        Object retVal = joinPoint.proceed();

        logger.debug("END METHOD VALUE CLASS=[{}] METHOD=[{}] VALUE=[{}]",
                joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(),
                retVal != null ? retVal.toString() : null);

        // Stopping Time.
        stopWatch.stop();

        logger.debug("METHOD EXECUTED TIME CLASS=[{}] METHOD=[{}] TotalTimeMillis=[{}]",
                joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return retVal;
    }

}
