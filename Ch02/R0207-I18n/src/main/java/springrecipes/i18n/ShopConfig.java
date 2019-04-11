package springrecipes.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import springrecipes.i18n.domain.Battery;
import springrecipes.i18n.domain.Disc;
import springrecipes.i18n.domain.Product;

@Configuration
public class ShopConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }
//
//    @Bean
//    public Cashier cashier() {
//        Cashier cashier = new Cashier();
//        return cashier;
//    }

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
