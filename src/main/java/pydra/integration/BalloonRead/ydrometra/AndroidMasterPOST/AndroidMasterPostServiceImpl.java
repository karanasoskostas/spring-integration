package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AndroidMasterPostServiceImpl implements AndroidMasterPostService{

    @Autowired
    private AndroidMasterPostRepository eRepository;

    @Override
    public AndroidMasterPost getSingleAndroidMasterPost(Long id) {
        Optional<AndroidMasterPost> masterpost = eRepository.findById(id);
        return masterpost.get();
    }
}
