package pydra.integration.SOAP.AFM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pydra.integration.Fpersons.Fpersons;

import java.net.MalformedURLException;

@Controller
public class AFMController {

    @Autowired
    private AFMService eService;

    @GetMapping("afm/version")
    public ResponseEntity<String> getVersion(){
        return new ResponseEntity<String>(eService.getAFMVersion(),HttpStatus.OK);
    }

    @GetMapping("afm/{afm}")
    public ResponseEntity<String> getAFM(@PathVariable("afm") String afm)  {

        try {
             return new ResponseEntity<String>(eService.getAFM(afm),HttpStatus.OK);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
    }

}
