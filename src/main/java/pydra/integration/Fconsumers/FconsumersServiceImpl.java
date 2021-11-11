package pydra.integration.Fconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.BalloonRead.ydrometra.FconsumersOnceDTO;
import pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetailimages.Androiduploaddetailimages;
import pydra.integration.Snd_genpar.Sndgenpar;
import pydra.integration.Snd_genpar.SndgenparService;
import pydra.integration.exception.GeneralException;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FconsumersServiceImpl implements FconsumersService{

    @Autowired
    private FconsumersRepository eRepository;

    @Autowired
    private SndgenparService genparService;



    @Override
    public Fconsumers getSingleFconsumer(Long id) {
        Optional<Fconsumers> fconsumer = eRepository.findById(id);
        Androiduploaddetailimages a;

        return fconsumer.get();
    }

    @Override
    public List<FconsumersOnceDTO> getFconsumersOnceDTO(){
        List<FconsumersOnceDTO> dtos = null;
        try {
            dtos = eRepository.findById(100L)
                    .stream()
                    .map(this::converttoDTO)
                    .collect(Collectors.toList());
        }catch (Exception ex){
            throw new GeneralException("FconsumersOnceDTO Exception :"+ex.getMessage());
        }
        if (dtos.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν Εγγραφές !");
        }
        return dtos;
    }


    private FconsumersOnceDTO converttoDTO(Fconsumers fconsumer)  {
        FconsumersOnceDTO dto = new FconsumersOnceDTO();
        String ls_address , ls_addr_no2;
        dto.code = fconsumer.getYdrometro();
        dto.serial_number = fconsumer.getYdrometro();
        if (fconsumer.getEmr() == 1){
            dto.type = "digital";
        }
        else {
            dto.type = "analog";
        }
        dto.latitude = fconsumer.getLatitude();
        dto.longitude = fconsumer.getLongitude();
        dto.length = null;
        dto.diameter = fconsumer.getFperdiam().getDiamdescr();
        dto.manufacturer = null;
        dto.model = null;
        dto.old_hydrometer = null;
        dto.date = null;
        dto.counter = null;
        dto.contact = fconsumer.getLiablename();
        if (fconsumer.getAddr_odos_akin() == null){
            ls_address = fconsumer.getPerigr_addr();
        }
        else{
            if (fconsumer.getAddr_no2() == null) {
                ls_addr_no2 = "";
            } else {
                ls_addr_no2 = fconsumer.getAddr_no2();
            }
            ls_address = fconsumer.getFaddress().getAddress()+" "+fconsumer.getAddr_no1().toString()+" "+ls_addr_no2;
        }
        dto.address = ls_address;
        dto.description = fconsumer.getParathr();

        Sndgenpar genpar = genparService.getGenpar(1L);
        fconsumer.setDiadromhformat(genpar.getDiadromhformat());
        try {
            dto.kwdikos_katanalwti = fconsumer.getCode();
        } catch (ParseException ex) {
            throw new GeneralException("FconsumersOnceDTO converttoDTO dto.kwdikos_katanalwti = fconsumer.getCode() Exception :"+ex.getMessage());
        }

        dto.sector = fconsumer.getSector().getSectdescr();

        return dto;
    }
}
