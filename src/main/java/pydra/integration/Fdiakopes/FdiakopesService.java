package pydra.integration.Fdiakopes;



import java.util.List;

public interface FdiakopesService {

    List<Fdiakopes> getFdiakopes();

    List<Fdiakopes> getFdiakopesOpen();

    List<FdiakopesDTO> getFdiakopesDTOOpen();

    Fdiakopes saveFdiakopes(Fdiakopes fdiakopes);


}
