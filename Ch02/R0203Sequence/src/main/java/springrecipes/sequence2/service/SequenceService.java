package springrecipes.sequence2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springrecipes.sequence2.dao.Sequence;
import springrecipes.sequence2.dao.SequenceDao;
import springrecipes.sequence2.dao.SequenceDaoImpl;

@Component
@Import(SequenceDaoImpl.class)
public class SequenceService {
    @Autowired
    private SequenceDao sequenceDao;

//    @Autowired
//    public SequenceService(SequenceDao sequenceDao) {
//        this.sequenceDao = sequenceDao;
//    }

    public SequenceService() {
    }

    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getId() + value + sequence.getSuffix();
    }
}
