package pydra.integration.AndroidMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;
import java.util.Optional;

@Service
public class AndroidmasterServiceImpl implements AndroidmasterService {

    @Autowired
    private AndroidmasterRepository eRepository;

    @Override
    public List<Androidmaster> getAndroidmaster() {
        List<Androidmaster> aMaster = null;
        try {
            aMaster = eRepository.findAll();
        } catch (Exception ex){
            throw new GeneralException("AndroidMaster Exception :"+ex.getMessage());
        }
        if (aMaster.isEmpty()){
            throw new GeneralException("Ο πίνακας AndroidMaster δεν έχει εγγραφές !");
        }

        return aMaster;
    }

    @Override
    public Androidmaster getAndroidmasterById(Long id) {
        Optional<Androidmaster> master = eRepository.findById(id);
        return master.get();
    }
}
