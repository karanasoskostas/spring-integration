package pydra.integration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pydra.integration.model.Androidmaster;
import pydra.integration.service.AndroidmasterService;

import java.util.List;

@RestController
public class AndroidmasterController {

    @Autowired
    private AndroidmasterService eService;


    @GetMapping("/androidmaster")
    public ResponseEntity<List<Androidmaster>> getAndroidmaster() {
        return new ResponseEntity<List<Androidmaster>>(eService.getAndroidmaster(), HttpStatus.OK);
    }

}
