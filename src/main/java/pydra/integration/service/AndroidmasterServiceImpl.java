package pydra.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.model.Androidmaster;
import pydra.integration.repository.AndroidmasterRepository;
import pydra.integration.repository.EmployeeRepository;

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
