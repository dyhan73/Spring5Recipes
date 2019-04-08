package springrecipes.sequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SequenceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SequenceApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
//		SequenceGenerator sequenceGenerator = (SequenceGenerator) context.getBean("sequenceGenerator");
		SequenceGenerator sequenceGenerator = context.getBean("sequenceGenerator", SequenceGenerator.class);

		System.out.println(sequenceGenerator.getSequence());
		System.out.println(sequenceGenerator.getSequence());
	}
}
