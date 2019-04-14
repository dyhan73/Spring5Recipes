package springrecipes.r0209;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.r0209.domain.Product;

@SpringBootApplication
public class R0209Application {

    public static void main(String[] args) {
//        SpringApplication.run(R0209Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext("springrecipes.r0209");
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);
    }

}
