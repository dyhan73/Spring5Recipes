package springrecipes.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.i18n.domain.Product;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class I18nApplication {

    public static void main(String[] args) {
//        SpringApplication.run(I18nApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext("springrecipes.i18n");
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("alert.inventory.checkout",
                new Object[] {"[DVD-RW 3.0]", new Date()}, Locale.US);

        System.out.println("The I18N messge for alert.checkout is: " + alert);
        System.out.println("The I18N messge for alert.inventory.checkout is: " + alert_inventory);


        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        cart1.addItem(cdrw);
//        System.out.println("Cart 1 contains " + cart1.getItems());

        Cashier cashier = context.getBean("cashier", Cashier.class);
        System.out.println(cashier.checkout(cart1));
    }

}
