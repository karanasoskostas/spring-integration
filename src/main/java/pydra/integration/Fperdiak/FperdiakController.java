package pydra.integration.Fperdiak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pydra.integration.test.EidopModel;

import java.util.List;

@Controller
public class FperdiakController {

    @Autowired
    private FperdiakService eService;

    @GetMapping("/fperdiak")
    public ResponseEntity<List<Fperdiak>> getFperdiak(){
        return new ResponseEntity<List<Fperdiak>>(eService.getFperdiak(),HttpStatus.OK);
    }

//    @GetMapping("/eidop")
//    public ResponseEntity<List<EidopModel>> geteidopmodel(){
//        return new ResponseEntity<List<EidopModel>>(eService.getEidopModel(),HttpStatus.OK);
//    }


}