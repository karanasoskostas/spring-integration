package pydra.integration.AndroidMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AndroidmasterServiceImpl implements AndroidmasterService {

    @Autowired
    private AndroidmasterRepository eRepository;

    @Override
    public List<Androidmaster> getAndroidmaster() {
        return eRepository.findAll();
    }
}
