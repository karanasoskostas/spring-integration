package pydra.integration.Snd_genpar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SndgenparController {


    @Autowired
    private SndgenparService eService;

    @GetMapping("/sndgenpar")
    public ResponseEntity<Sndgenpar> getSndgenpar(){
        System.out.println("getSndgenpar");
        return new ResponseEntity<Sndgenpar>(eService.getGenpar(1L), HttpStatus.OK);
    }

    @GetMapping("/sndgenpar/{id}")
    public ResponseEntity<Sndgenpar> getSndgenpar(@PathVariable("id") Long id){
        return new ResponseEntity<Sndgenpar>(eService.getGenpar(id), HttpStatus.OK);
    }

    @GetMapping("sndgenpar-test")
    public ResponseEntity<String> getTest(){
        return new ResponseEntity<String >("TEST",HttpStatus.OK);
    }
}
