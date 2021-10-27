package pydra.integration.Fdiakopes;

import pydra.integration.Fdiakopes.Fdiakopes;

import java.util.List;

public interface FdiakopesService {

    List<Fdiakopes> getFdiakopes();

    List<Fdiakopes> getFdiakopesOpen();

    Fdiakopes saveFdiakopes(Fdiakopes fdiakopes);
}
