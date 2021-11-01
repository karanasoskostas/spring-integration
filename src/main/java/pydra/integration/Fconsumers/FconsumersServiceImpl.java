package pydra.integration.Fconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FconsumersServiceImpl implements FconsumersService{

    @Autowired
    private FconsumersRepository eRepository;

    @Override
    public Fconsumers getSingleFconsumer(Long id) {
        Optional<Fconsumers> fconsumer = eRepository.findById(id);
        return fconsumer.get();
    }
}
