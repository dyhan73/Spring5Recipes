package springrecipes.r0208;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.r0208.domain.Product;

@SpringBootApplication
public class Recipe28Application {

    public static void main(String[] args) {
//        SpringApplication.run(Recipe28Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("springrecipes.r0208");

        Cashier cashier = context.getBean("cashier", Cashier.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        cart1.addItem(dvdrw);

        try {
            cashier.checkout(cart1);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

}
