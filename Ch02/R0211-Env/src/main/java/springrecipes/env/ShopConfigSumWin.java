package springrecipes.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springrecipes.env.domain.Battery;
import springrecipes.env.domain.Disc;
import springrecipes.env.domain.Product;

@Configuration
@Profile({"summer", "winter"})
public class ShopConfigSumWin {

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
