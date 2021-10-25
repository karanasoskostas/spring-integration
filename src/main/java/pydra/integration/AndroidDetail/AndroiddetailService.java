package pydra.integration.AndroidDetail;

import pydra.integration.AndroidDetail.Androiddetail;

import java.util.List;


public interface AndroiddetailService {

    List<Androiddetail> getAndroiddetail();

    List<Androiddetail> getAndroiddetailbyFileid(Long file_id);
}
