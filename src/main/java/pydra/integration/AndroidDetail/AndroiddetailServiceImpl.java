package pydra.integration.AndroidDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return eRepository.findByFileid(file_id);
    }


}
