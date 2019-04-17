package springrecipes.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CalculatorValidationAspect {

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* springrecipes.aop.*.*(double, double))")
    public void validateBefore(JoinPoint joinPoint) {
        log.info("Start argument validation");
        for (Object arg : joinPoint.getArgs()) {
            validate((Double) arg);
        }
    }

    private void validate(Double arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }
}
