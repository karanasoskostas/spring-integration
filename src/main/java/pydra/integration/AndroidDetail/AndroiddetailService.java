package pydra.integration.AndroidDetail;

import pydra.integration.AndroidDetail.Androiddetail;

import java.util.List;
import java.util.Optional;


public interface AndroiddetailService {

    List<Androiddetail> getAndroiddetail();

    List<Androiddetail> getAndroiddetailbyFileid(Long file_id);

    Androiddetail findByFileIdnadYdrometro(Long file_id, String ydrometro);
}
