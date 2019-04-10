package springrecipes.sequence2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
//    @Autowired
//    @Qualifier("datePrefixGenerator")
    @Resource
    private PrefixGenerator prefixGenerator;
    // private PrefixGenerator[] prefixGenerators;
    // private List<PrefixGenerator> prefixGenerators;

    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {

    }

    public SequenceGenerator(String suffix, int initial) {
        setSuffix(suffix);
        setInitial(initial);
    }

    @Autowired(required = false)
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        return prefixGenerator.getPrefix()
                + initial
                + counter.getAndIncrement()
                + suffix;
    }
}
