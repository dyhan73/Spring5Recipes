package springrecipes.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class CalculatorLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    @Pointcut("execution(* springrecipes.aop.*.*(..))")
    private void loggingOperation() {}

    @Before("loggingOperation()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName() +
                "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* springrecipes.aop.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    @AfterReturning(
            pointcut = "loggingOperation()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
    }

    @AfterThrowing(
            pointcut = "loggingOperation()",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
    }

    @Around("loggingOperation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(String.format("The method %s() begins with %s"
                , joinPoint.getSignature().getName()
                , Arrays.toString(joinPoint.getArgs())));

        try {
            Object result = joinPoint.proceed();
            log.info(String.format("The method %s() ends with %s"
                    , joinPoint.getSignature().getName()
                    , result));
            return result;
        } catch (IllegalArgumentException e) {
            log.error(String.format("Illegal argument %s in %s()",
                    Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName()));
            throw e;
        }
    }

//    @Before("execution(* springrecipes.aop.*.*(..))")
//    public void logJoinPoint(JoinPoint joinPoint) {
//        log.info("Join point kind : " + joinPoint.getKind());
//        log.info("Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
//        log.info("Signature name : " + joinPoint.getSignature().getName());
//        log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
//        log.info("Target class : " + joinPoint.getTarget().getClass().getName());
//        log.info("This class : " + joinPoint.getThis().getClass().getName());
//    }
}
