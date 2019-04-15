package springrecipes.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.env.domain.Battery;
import springrecipes.env.domain.Product;

@SpringBootApplication
public class EnvApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EnvApplication.class, args);

        // loading environment (programmatically way)
        // - alternative way : using -Dspring.profiles.active=global,winter (as runtime flag)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("global", "winter");
        context.scan("springrecipes.env");
        context.refresh();

        Product aaa = context.getBean("aaa", Battery.class);
        System.out.println(aaa);
    }

}
