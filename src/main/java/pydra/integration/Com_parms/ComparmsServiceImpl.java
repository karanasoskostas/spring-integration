package pydra.integration.Com_parms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComparmsServiceImpl implements ComparmsService{

    @Autowired
    private ComparmsRepository eRepository;

    @Override
    public Comparms getComparms(Long id) {
        Optional<Comparms> comparm = eRepository.findById(1L);
        return comparm.get();
    }
}
