package pydra.integration.Dual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DualServiceImpl implements DualService{

    @Autowired
    private DualRepository eRepozitory;

    @Override
    public Long getSeqYdrGeneralnextval() {
        return eRepozitory.getYdrGeneralSeqnextval();
    }
}
