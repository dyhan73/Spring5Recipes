package springrecipes.sequence;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SequenceGeneratorTest {

    @Test
    public void getSequence() {
        String prefix = "Pre";
        String post = "Post";
        int initial = 1;

        SequenceGenerator sequenceGenerator = new SequenceGenerator(prefix, post, initial);

        assertThat(sequenceGenerator.getSequence(), is("Pre10Post"));
        assertThat(sequenceGenerator.getSequence(), is("Pre11Post"));
    }
}