package pydra.integration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pydra.integration.model.Fdiakopes;
import pydra.integration.service.FdiakopesService;

import java.util.List;

@Controller
public class FdiakopesController {

    @Autowired
    private FdiakopesService eService;

    @GetMapping("/fdiakopes")
    ResponseEntity<List<Fdiakopes>> getFdiakopes(){
        return new ResponseEntity<List<Fdiakopes>>(eService.getFdiakopesOpen(), HttpStatus.OK);
    }

}
