package pydra.integration.Fconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pydra.integration.Snd_genpar.GetgenparOnStart;
import pydra.integration.Snd_genpar.Sndgenpar;
import pydra.integration.Snd_genpar.SndgenparService;

@Controller
public class FconsumersController {

    @Autowired
    private FconsumersService eService;

    @Autowired
    private SndgenparService genparService;


    @GetMapping("/fconsumers/{id}")
    public ResponseEntity<Fconsumers> getConsumerbyId(@PathVariable("id") Long id){
        Sndgenpar genpar = genparService.getGenpar(1L);    // για το formatt της διαδρομης
        Fconsumers consumer = eService.getSingleFconsumer(id);
        consumer.setDiadromhformat(genpar.getDiadromhformat());  // διαδρομη formatt
        return new ResponseEntity<Fconsumers>(consumer, HttpStatus.OK);
    }
}
