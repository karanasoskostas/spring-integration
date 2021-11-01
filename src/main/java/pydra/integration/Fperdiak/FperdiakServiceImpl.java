package pydra.integration.Fperdiak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.test.EidopModel;
import pydra.integration.test.EidopRepositoryold;

import java.util.List;

@Service
public class FperdiakServiceImpl implements FperdiakService{

    @Autowired
    private FperdiakRepository eRepository;

    @Override
    public List<Fperdiak> getFperdiak() {
        return eRepository.findAll();
    }
}
