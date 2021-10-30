package pydra.integration.Ebill.Eidop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;

@Service
public class EidopServiceImpl implements EidopService{

    @Autowired
    private EidopRepository eRepository;

    public List<Eidop> getEidop(String fromdate, String todate) {
        List<Eidop> eidop = null;
        try {
            eidop = eRepository.getEidopModel(fromdate, todate);
        } catch (Exception ex) {
            throw new GeneralException("EidopService Exception :"+ex.getMessage());
        }
        if (eidop.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν Ειδοποιητήρια !");
        }
        return eidop;
    }

}
