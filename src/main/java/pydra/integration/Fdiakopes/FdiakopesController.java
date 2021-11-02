package pydra.integration.Fdiakopes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pydra.integration.Fdiakopes.Fdiakopes;
import pydra.integration.Fdiakopes.FdiakopesService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FdiakopesController {

    @Autowired
    private FdiakopesService eService;

    @GetMapping("/fdiakopes")
    public ResponseEntity<List<Fdiakopes>> getFdiakopes(){
        return new ResponseEntity<List<Fdiakopes>>(eService.getFdiakopesOpen(), HttpStatus.OK);
    }

    @PostMapping("/fdiakopes")
    public ResponseEntity<Fdiakopes> postFdiakopes(@Valid @RequestBody Fdiakopes fdiakopes){
        return new ResponseEntity<>(eService.saveFdiakopes(fdiakopes), HttpStatus.OK);
    }

    @GetMapping("/fdiakopesdto")
    public ResponseEntity<List<FdiakopesDTO>> getFdiakopesDTO(){
        return new ResponseEntity<List<FdiakopesDTO>>(eService.getFdiakopesDTOOpen(), HttpStatus.OK);
    }


}
