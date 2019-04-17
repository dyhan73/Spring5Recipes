package springrecipes.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcuts {

//    @Pointcut("execution(* springrecipes.aop.*.*(..))")
//    @Pointcut("@annotation(springrecipes.aop.aspect.LoggingRequired)")
    @Pointcut("within(springrecipes.aop.calculator.UnitCalculator+) || within(springrecipes.aop.calculator.ArithmeticCalculator+)")
    public void loggingOperation() {}
}
