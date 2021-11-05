package pydra.integration.Snd_genpar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SndgenparServiceImpl implements SndgenparService {

    @Autowired
    private SndgenparRepository eRepository;


    @Override
    public Sndgenpar getGenpar(Long Id) {
        Optional<Sndgenpar> genpar =  eRepository.findById(Id);
        return genpar.get();
    }
}

