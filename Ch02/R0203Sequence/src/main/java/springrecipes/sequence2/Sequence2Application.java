package springrecipes.sequence2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springrecipes.sequence2.service.SequenceGenerator;
import springrecipes.sequence2.service.SequenceService;

@SpringBootApplication
public class Sequence2Application {

    public static void main(String[] args) {
//        SpringApplication.run(Sequence2Application.class, args);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SequenceConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext("springrecipes.sequence2");
        SequenceGenerator sequenceGenerator = context.getBean("sequenceGenerator", SequenceGenerator.class);
        System.out.println(sequenceGenerator.getSequence());
        System.out.println(sequenceGenerator.getSequence());

        SequenceService sequenceService = context.getBean("sequenceService", SequenceService.class);
        System.out.println(sequenceService.generate("IT"));
        System.out.println(sequenceService.generate("IT"));

        System.out.println("asdf");
        System.out.println("asdf");
    }

}
