package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pydra.integration.Employee.Employee;

@RestController
public class AndroidUploadDetailController {

    @Autowired
    private AndroiduploaddetailService eService;


    @PostMapping("/androiduploaddetail")
    public ResponseEntity<PostDetail> saveAndroidUploadDetail(@RequestBody PostDetail detail){
        System.out.println("inside");
        System.out.println(detail);
        return new ResponseEntity<PostDetail>(detail,HttpStatus.CREATED);
    }
}
