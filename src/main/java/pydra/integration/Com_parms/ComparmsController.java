package pydra.integration.Com_parms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComparmsController {

    @Autowired
    private ComparmsService eService;

    @GetMapping("/comparms")
    public ResponseEntity<Comparms> getComparms(){
        return new ResponseEntity<Comparms>(eService.getComparms(1L), HttpStatus.OK);
    }
}
