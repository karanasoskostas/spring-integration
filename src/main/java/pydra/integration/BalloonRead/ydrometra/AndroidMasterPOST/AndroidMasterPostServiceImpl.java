package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.Optional;

@Service
public class AndroidMasterPostServiceImpl implements AndroidMasterPostService{

    @Autowired
    private AndroidMasterPostRepository eRepository;

    @Override
    public AndroidMasterPost getSingleAndroidMasterPost(Long id) {
        Optional<AndroidMasterPost> masterpost = null;
        try {
            masterpost = eRepository.findById(id);
        } catch(Exception ex){
            throw new GeneralException("AndroidMasterPost getSingleAndroidMasterPost Exception :"+ex.getMessage());
        }
        if (masterpost.isEmpty()){
            throw new GeneralException("Δεν βρέθηκε Εγγραφή AndroidMaster με ΙD : "+id.toString());
        }
        return masterpost.get();
    }
}
