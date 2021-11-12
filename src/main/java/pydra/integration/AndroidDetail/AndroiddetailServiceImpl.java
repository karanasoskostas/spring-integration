package pydra.integration.AndroidDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;

@Service
public class AndroiddetailServiceImpl implements AndroiddetailService{

    @Autowired
    private AndroiddetailRepository  eRepository;

    @Override
    public List<Androiddetail> getAndroiddetail() {
        return eRepository.findAll();
    }

    @Override
    public List<Androiddetail> getAndroiddetailbyFileid(Long file_id) {
        List<Androiddetail> aDetail = null;
        try{
            aDetail =  eRepository.findByFileid(file_id);
        }catch (Exception ex){
            throw new GeneralException("AndroidDetail Exception :"+ex.getMessage());
        }
        if (aDetail.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν εγγραφές με το ID :"+file_id);
        }
        return aDetail;
    }

    @Override
    public Androiddetail findByFileIdnadYdrometro(Long file_id, String ydrometro) {
        return eRepository.findByFileidAndYdrometro(file_id, ydrometro);
    }


}
