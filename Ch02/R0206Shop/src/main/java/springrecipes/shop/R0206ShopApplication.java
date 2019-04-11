package springrecipes.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import springrecipes.shop.domain.Product;

import java.util.Properties;

@SpringBootApplication
public class R0206ShopApplication {

	public static void main(String[] args) {
//		SpringApplication.run(R0206ShopApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);

		Product dvdrw = context.getBean("dvdrw", Product.class);
		System.out.println(dvdrw);

		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
				context.getBean("propertySourcesPlaceholderConfigurer", PropertySourcesPlaceholderConfigurer.class);
		System.out.println(propertySourcesPlaceholderConfigurer);
//		propertySourcesPlaceholderConfigurer.getAppliedPropertySources();

		Resource resource = new ClassPathResource("discounts.properties");
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			System.out.println("And don't forget our discounts!");
			System.out.println(props);
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}

}
