package pydra.integration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pydra.integration.model.Androiddetail;
import pydra.integration.service.AndroiddetailService;

import java.util.List;

@RestController
public class AndroiddetailController {

    @Autowired
    private AndroiddetailService eService;

    @GetMapping("/androiddetail")
    ResponseEntity<List<Androiddetail>> getAndroiddetail(){
        return new ResponseEntity<List<Androiddetail>>(eService.getAndroiddetail(),HttpStatus.OK);
    }

    @GetMapping("/androiddetail/{file_id}")
    ResponseEntity<List<Androiddetail>> getAndroiddetailByFile_Id(@PathVariable Long file_id){
        return new ResponseEntity<List<Androiddetail>>(eService.getAndroiddetailbyFileid(file_id),HttpStatus.OK);
    }


}
