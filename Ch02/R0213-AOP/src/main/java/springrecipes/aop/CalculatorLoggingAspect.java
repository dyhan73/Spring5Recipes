package springrecipes.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect implements Ordered {

    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public int getOrder() {
        return 1;
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


//    @Around("execution(* springrecipes.aop.*.*(..))")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info(String.format("The method %s() begins with %s"
//                , joinPoint.getSignature().getName()
//                , Arrays.toString(joinPoint.getArgs())));
//
//        try {
//            Object result = joinPoint.proceed();
//            log.info(String.format("The method %s() ends with %s"
//                    , joinPoint.getSignature().getName()
//                    , result));
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error(String.format("Illegal argument %s in %s()",
//                    Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName()));
//            throw e;
//        }
//    }

    @Before("execution(* springrecipes.aop.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName() +
                "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

//    @After("execution(* springrecipes.aop.*.*(..))")
//    public void logAfter(JoinPoint joinPoint) {
//        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
//    }
//
//    @AfterReturning(
//            pointcut = "execution(* springrecipes.aop.*.*(..))",
//            returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//        log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* springrecipes.aop.*.*(..))",
//            throwing = "e")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
//    }
}
