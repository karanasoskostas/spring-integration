package pydra.integration.AndroidMaster;

import pydra.integration.AndroidMaster.Androidmaster;

import java.util.List;

public interface AndroidmasterService {

    List<Androidmaster> getAndroidmaster();

    Androidmaster getAndroidmasterById(Long id);

}
