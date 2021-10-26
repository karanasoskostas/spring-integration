package pydra.integration.Ebill.Eidop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EidopController {

    @Autowired
    private EidopService eService;

    @GetMapping("/ebill/eidop")
    ResponseEntity<List<Eidop>> getEidop(@RequestParam String fromdate, @RequestParam String todate){
        return new ResponseEntity<List<Eidop>>(eService.getEidop(fromdate, todate), HttpStatus.OK);
    }


}
