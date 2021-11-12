package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class AndroidUploadDetailController {

    @Autowired
    private AndroiduploaddetailService eService;


    @PostMapping("/androiduploaddetail")
    public ResponseEntity<String> saveAndroidUploadDetail(@RequestBody AndroidUploadDetail detail){
        System.out.println("inside");
        System.out.println(detail.getSerial_number());
        detail.setId(1L);
        detail.setFileid(1L);
        eService.saveAndroidUploadDetail(detail);
        return new ResponseEntity<String>("OK",HttpStatus.CREATED);
    }

    @PostMapping("/androiduploaddetaillist")
    public ResponseEntity<String> saveAndroidUploadDetailList(@RequestBody List<AndroidUploadDetail> detaillist){
//        System.out.println("inside list");
        AndroidUploadDetail detail;
        for(int i=0; i< detaillist.size(); i++){
            detail = detaillist.get(i);
            detail.setId((long) i);
            detail.setFileid((long) i);
            eService.saveAndroidUploadDetail(detail);


        }
//        System.out.println(detail.getSerial_number());
//        detail.setId(1L);
//        detail.setFileid(1L);
//        eService.saveAndroidUploadDetail(detail);
        return new ResponseEntity<String>("OK",HttpStatus.CREATED);
    }
}
