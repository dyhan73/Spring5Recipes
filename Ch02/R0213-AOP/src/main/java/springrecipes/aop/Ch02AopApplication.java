package springrecipes.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springrecipes.aop.calculator.ArithmeticCalculator;
import springrecipes.aop.calculator.UnitCalculator;

@SpringBootApplication
public class Ch02AopApplication implements CommandLineRunner {

    private final ArithmeticCalculator arithmeticCalculator;
    private final UnitCalculator unitCalculator;

    // @Autowired // is not needed when injected class has only one constructor
    public Ch02AopApplication(ArithmeticCalculator arithmeticCalculator, UnitCalculator unitCalculator) {
        this.arithmeticCalculator = arithmeticCalculator;
        this.unitCalculator = unitCalculator;
    }

    @Override
    public void run(String... args) {
        System.out.println(arithmeticCalculator.add(1.2, 2.4));
        System.out.println(unitCalculator.kilogramToPound(74.1));

        try {
            System.out.println(arithmeticCalculator.div(4.2, 0));
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        try {
            System.out.println(arithmeticCalculator.add(1.2, -2.4));
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch02AopApplication.class, args);
    }
}
