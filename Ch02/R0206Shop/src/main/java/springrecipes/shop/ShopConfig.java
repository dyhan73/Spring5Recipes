package springrecipes.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import springrecipes.shop.domain.Disc;
import springrecipes.shop.domain.Product;

@Configuration
@PropertySource("classpath:discounts.properties")
//@ComponentScan("springrecipes.shop")
public class ShopConfig {

    @Value("${endofyear.discount:0}")
    private double specialEndofYearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0, specialEndofYearDiscountField);
        p2.setCapacity(700);
        return p2;
    }

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }
}
