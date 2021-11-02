package pydra.integration.Fdiakopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.Fdiakopes.Fdiakopes;
import pydra.integration.Fdiakopes.FdiakopesRepository;
import pydra.integration.Fdiakopes.FdiakopesService;
import pydra.integration.Fdiakopes.FdiakopesDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<FdiakopesDTO> getFdiakopesDTOOpen() {
        return eRepository.getFdiakopesOpen()
                .stream()
                .map(this::converttoDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Fdiakopes saveFdiakopes(Fdiakopes fdiakopes) {
        return eRepository.save(fdiakopes);
    }



   private FdiakopesDTO converttoDTO(Fdiakopes fdiakopes){
        FdiakopesDTO fdto = new FdiakopesDTO();
        fdto.setDiakophId(fdiakopes.getId());
        fdto.setDiakophAa(fdiakopes.getAa());
        fdto.setDiakophDate(fdiakopes.getDatediak());
        fdto.setDiakophEidos(fdiakopes.getDiakeidos());
        fdto.setMaa(fdiakopes.getMaa());
        fdto.setDiakophDescr(fdiakopes.getFperdiak().getRpdiakdescr());

        return fdto;
   }

}
