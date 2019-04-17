package springrecipes.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcuts {

//    @Pointcut("execution(* springrecipes.aop.*.*(..))")
//    @Pointcut("@annotation(springrecipes.aop.LoggingRequired)")
    @Pointcut("within(UnitCalculator+) || within(ArithmeticCalculator+)")
    public void loggingOperation() {}
}
