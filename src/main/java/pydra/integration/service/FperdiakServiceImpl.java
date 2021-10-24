package pydra.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pydra.integration.model.Fperdiak;
import pydra.integration.repository.FperdiakRepository;

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
