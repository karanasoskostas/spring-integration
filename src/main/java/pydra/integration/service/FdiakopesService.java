package pydra.integration.service;

import pydra.integration.model.Fdiakopes;

import java.util.List;

public interface FdiakopesService {

    List<Fdiakopes> getFdiakopes();

    List<Fdiakopes> getFdiakopesOpen();
}
