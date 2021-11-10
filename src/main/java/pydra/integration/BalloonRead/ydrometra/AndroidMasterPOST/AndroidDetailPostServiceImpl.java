package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;

@Service
public class AndroidDetailPostServiceImpl implements  AndroidDetailPostService{

    @Autowired
    private AndroidDetailPostRepository eRepository;

    @Override
    public List<AndroidDetailPost> getallByFileId(Long file_id) {
        List<AndroidDetailPost> detail = null;
        try{
            detail = eRepository.findByFile_id(file_id);
        } catch(Exception ex){
            throw new GeneralException("List<AndroidDetailPost> getallByFileId Exception :"+ex.getMessage());
        }
        if (detail.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκε AndroidDetail για file_id = "+file_id.toString());
        }
        return detail;
    }
}
