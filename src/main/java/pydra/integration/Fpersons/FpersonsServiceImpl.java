package pydra.integration.Fpersons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FpersonsServiceImpl implements FpersonsService{

    @Autowired
    private FpersonsRepository eRepository;


    @Override
    public Fpersons getSingleFpersons(Long id) {
        Optional<Fpersons> fperson = eRepository.findById(id);
        return fperson.get();
    }
}
