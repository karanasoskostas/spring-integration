package pydra.integration.Fkatamet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FkatametServiceImpl implements FkatametService{

    @Autowired
    private FkatametRepository eRepository;

    @Override
    public Fkatamet findByEmailaccount(String emailaccount) {
        return eRepository.findByEmailaccount(emailaccount);
    }
}
