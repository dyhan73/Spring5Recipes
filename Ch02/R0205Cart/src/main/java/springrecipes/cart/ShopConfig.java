package springrecipes.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springrecipes.cart.domain.Battery;
import springrecipes.cart.domain.Disc;
import springrecipes.cart.domain.Product;

@Configuration
@ComponentScan("springrecipes.cart")
public class ShopConfig {
    @Bean
    public Product aaa() {
        Battery prd = new Battery();
        prd.setName("AAA");
        prd.setPrice(2.5);
        prd.setRechargable(true);
        return prd;
    }

    @Bean
    public Product cdrw() {
        Disc prd = new Disc("CD-RW", 1.5);
        prd.setCapacity(700);
        return prd;
    }

    @Bean
    public Product dvdrw() {
        Disc prd = new Disc("DVD-RW", 3.0);
        prd.setCapacity(800);
        return prd;
    }
}
