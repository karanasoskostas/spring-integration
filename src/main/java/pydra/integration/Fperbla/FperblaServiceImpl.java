package pydra.integration.Fperbla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;

@Service
public class FperblaServiceImpl implements FperblaService{

    @Autowired
    private FperblaRepository eRepository;

    @Override
    public List<Fperbla> getFperbla() {
        List<Fperbla> fperbla = null;
        try {
            fperbla =  eRepository.findAll();
        } catch (Exception ex) {
            throw new GeneralException("Fperbla Exception : " + ex.getMessage());
        }
        if (fperbla.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν Βλάβες !");
        }
        return fperbla;
    }
}
