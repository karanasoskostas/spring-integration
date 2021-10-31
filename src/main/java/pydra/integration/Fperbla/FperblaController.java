package pydra.integration.Fperbla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FperblaController {

    @Autowired
    private FperblaService eService;

    @GetMapping("/fperbla")
    ResponseEntity<List<Fperbla>> getFperbla(){
        return new ResponseEntity<List<Fperbla>>(eService.getFperbla(), HttpStatus.OK);

    }

}
