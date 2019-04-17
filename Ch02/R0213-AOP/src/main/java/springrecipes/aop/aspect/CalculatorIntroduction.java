package springrecipes.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import springrecipes.aop.calculator.MaxCalculator;
import springrecipes.aop.calculator.MaxCalculatorImpl;
import springrecipes.aop.calculator.MinCalculator;
import springrecipes.aop.calculator.MinCalculatorImpl;

@Aspect
@Component
public class CalculatorIntroduction {

    @DeclareParents(
            value = "springrecipes.aop.calculator.ArithmeticCalculatorImpl",
            defaultImpl = MaxCalculatorImpl.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "springrecipes.aop.calculator.ArithmeticCalculatorImpl",
            defaultImpl = MinCalculatorImpl.class
    )
    public MinCalculator minCalculator;

}
