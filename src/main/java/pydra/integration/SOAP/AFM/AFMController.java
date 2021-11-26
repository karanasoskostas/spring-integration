package pydra.integration.SOAP.AFM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pydra.integration.Fpersons.Fpersons;

@Controller
public class AFMController {

    @Autowired
    private AFMService eService;

    @GetMapping("afm/version")
    public ResponseEntity<String> getVersion(){
        return new ResponseEntity<String>(eService.getAFMVersion(),HttpStatus.OK);
    }


}
