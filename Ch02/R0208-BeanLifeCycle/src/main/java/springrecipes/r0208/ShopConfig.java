package springrecipes.r0208;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springrecipes.r0208.domain.Battery;
import springrecipes.r0208.domain.Disc;
import springrecipes.r0208.domain.Product;

@Configuration
public class ShopConfig {

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        String path = System.getProperty("java.io.tmpdir") + "/cashier";
        Cashier c1 = new Cashier();
        c1.setFileName("checkout");
        c1.setPath(path);
        return c1;
    }

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
