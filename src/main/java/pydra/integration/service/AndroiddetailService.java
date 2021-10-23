package pydra.integration.service;

import org.springframework.stereotype.Service;
import pydra.integration.model.Androiddetail;

import java.util.List;


public interface AndroiddetailService {

    List<Androiddetail> getAndroiddetail();

    List<Androiddetail> getAndroiddetailbyFileid(Long file_id);
}
