package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploadmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndroiduploadmasterServiceImpl implements AndroiduploadmasterService{
    @Autowired
    private AndroiduploadmasterRepository eRepository;

    @Override
    public Androiduploadmaster saveAndroidUploadMaster(Androiduploadmaster master) {
        return eRepository.save(master);
    }

    @Override
    public Androiduploadmaster getById(Long id) {
        return eRepository.getById(id);
    }


}
