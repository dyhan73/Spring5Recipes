package springrecipes.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch02AopApplication implements CommandLineRunner {
    @Autowired
    private ArithmeticCalculator arithmeticCalculator;
    @Autowired
    private UnitCalculator unitCalculator;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(arithmeticCalculator.add(1.2, 2.4));
        System.out.println(unitCalculator.kilogramToPound(74.1));
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch02AopApplication.class, args);
    }
}
