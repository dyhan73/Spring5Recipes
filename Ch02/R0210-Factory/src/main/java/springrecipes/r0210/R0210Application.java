package springrecipes.r0210;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.r0210.domain.Product;

@SpringBootApplication
public class R0210Application {

    public static void main(String[] args) {
//        SpringApplication.run(R0210Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("springrecipes.r0210");

        Product aaa = context.getBean("aaa", Product.class);

        System.out.println(aaa);
    }

}
