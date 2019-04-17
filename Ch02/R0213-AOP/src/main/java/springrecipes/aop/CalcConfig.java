package springrecipes.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springrecipes.aop.calculator.ArithmeticCalculator;
import springrecipes.aop.calculator.ArithmeticCalculatorImpl;
import springrecipes.aop.calculator.UnitCalculator;
import springrecipes.aop.calculator.UnitCalculatorImpl;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class CalcConfig {

    @Bean
    public ArithmeticCalculator arithmeticCalculator() {
        return new ArithmeticCalculatorImpl();
    }

    @Bean
    public UnitCalculator unitCalculator() {
        return new UnitCalculatorImpl();
    }
}
