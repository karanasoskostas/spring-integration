package pydra.integration.Ebill.Eidop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EidopServiceImpl implements EidopService{

    @Autowired
    private EidopRepository eRepository;

    public List<Eidop> getEidop() {
        return eRepository.getEidopModel();
    }

}
