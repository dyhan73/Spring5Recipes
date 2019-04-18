package springrecipes.complex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComplexApplication implements CommandLineRunner {

    private final ComplexCalculator complexCalculator;

    public ComplexApplication(ComplexCalculator complexCalculator) {
        this.complexCalculator = complexCalculator;
    }

    @Override
    public void run(String... args) throws Exception {
        complexCalculator.add(new Complex(1, 2), new Complex(2,3));
        complexCalculator.sub(new Complex(5, 8), new Complex(2,3));
    }

    public static void main(String[] args) {
        SpringApplication.run(ComplexApplication.class, args);
    }

}
