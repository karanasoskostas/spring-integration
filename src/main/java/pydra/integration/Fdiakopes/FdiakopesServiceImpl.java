package pydra.integration.Fdiakopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.Fdiakopes.Fdiakopes;
import pydra.integration.Fdiakopes.FdiakopesRepository;
import pydra.integration.Fdiakopes.FdiakopesService;

import java.util.List;

@Service
public class FdiakopesServiceImpl implements FdiakopesService {

    @Autowired
    private FdiakopesRepository eRepository;

    @Override
    public List<Fdiakopes> getFdiakopes() {
        return eRepository.findAll();
    }

    @Override
    public List<Fdiakopes> getFdiakopesOpen() {
        return eRepository.getFdiakopesOpen();
    }
}
