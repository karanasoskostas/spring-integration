package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndroiduploaddetailServiceImpl implements AndroiduploaddetailService{

    @Autowired
    private  AndroidUploadDetailRepository eRepository;

    @Override
    public AndroidUploadDetail saveAndroidUploadDetail(AndroidUploadDetail detail) {
        return eRepository.save(detail);
    }
}
