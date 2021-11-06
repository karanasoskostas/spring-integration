package pydra.integration.Fconsumers;

import pydra.integration.BalloonRead.ydrometra.FconsumersOnceDTO;

import java.util.List;

public interface FconsumersService {

    Fconsumers getSingleFconsumer(Long id);

    List<FconsumersOnceDTO> getFconsumersOnceDTO();
}
