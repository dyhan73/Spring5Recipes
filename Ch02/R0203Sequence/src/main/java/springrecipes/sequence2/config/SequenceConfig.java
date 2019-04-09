package springrecipes.sequence2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springrecipes.sequence2.service.PrefixGenerator;
import springrecipes.sequence2.service.SequenceGenerator;
import springrecipes.sequence2.service.SequenceService;

@Configuration
@Import(PrefixConf.class)
public class SequenceConfig {

    @Value("#{datePrefixGenerator}")
    private PrefixGenerator prefixGenerator;

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setInitial(100000);
        sequenceGenerator.setSuffix("A");
        sequenceGenerator.setPrefixGenerator(prefixGenerator);
        return sequenceGenerator;
    }

    @Bean
    public SequenceService sequenceService() {

        SequenceService sequenceService = new SequenceService();
        return sequenceService;
    }
}
