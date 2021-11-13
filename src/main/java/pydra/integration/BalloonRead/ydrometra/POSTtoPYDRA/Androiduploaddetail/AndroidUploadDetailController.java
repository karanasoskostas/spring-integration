package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pydra.integration.AndroidDetail.Androiddetail;
import pydra.integration.AndroidDetail.AndroiddetailRepository;
import pydra.integration.AndroidDetail.AndroiddetailService;
import pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetailimages.Androiduploaddetailimages;
import pydra.integration.Dual.DualRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Controller
public class AndroidUploadDetailController {

    @Autowired
    private AndroiduploaddetailService eService;
    @Autowired
    private AndroiddetailService androiddetailService;
    @Autowired
    private DualRepository dualRepository;


    @PostMapping("/androiduploaddetail")
    public ResponseEntity<String> saveAndroidUploadDetail(@RequestBody AndroidUploadDetail detail){
        System.out.println("inside");
        System.out.println(detail.getSerial_number());
        detail.setId(1L);
//        detail.setFileid(1L);
        eService.saveAndroidUploadDetail(detail);
        return new ResponseEntity<String>("OK",HttpStatus.CREATED);
    }

    @PostMapping("/androiduploaddetaillist")
    public ResponseEntity<String> saveAndroidUploadDetailList(@RequestBody List<AndroidUploadDetail> uploaddetaillist){
        AndroidUploadDetail uploaddetail;
        Androiddetail androiddetail;
        Long file_id;
        Long ydrometra_good = 0L;
        Long ydrometra_bad = 0L;
        Integer ydrometra_all = 0;
        String ydrometro , return_body="";
        Long detail_id;
        List<Androiduploaddetailimages> images;
        String damages[];
        Long nea;

        ydrometra_all =  uploaddetaillist.size();

        for(int i=0; i< uploaddetaillist.size(); i++){
            uploaddetail = uploaddetaillist.get(i);
            file_id = uploaddetail.getRoutelist();
            ydrometro = uploaddetail.getSerial_number();

            androiddetail = androiddetailService.findByFileIdnadYdrometro(file_id,ydrometro);
            if (androiddetail == null) {
                ydrometra_bad = ydrometra_bad + 1;
                continue;
            }
            ydrometra_good = ydrometra_good + 1;

            uploaddetail.setAa(androiddetail.getAa());
            uploaddetail.setDeyaaa(androiddetail.getDeya_aa());
            uploaddetail.setMaa(androiddetail.getMaa());
            uploaddetail.setTomeas(androiddetail.getTomeas());
            uploaddetail.setCode(androiddetail.getCode());
            uploaddetail.setStatus(androiddetail.getStatus());
            uploaddetail.setName(androiddetail.getName());
            uploaddetail.setAddress(androiddetail.getAddress());
            uploaddetail.setProhg(androiddetail.getProhg());
            uploaddetail.setMetrhseis(androiddetail.getMetrhseis());
            uploaddetail.setCom(androiddetail.getCom());
            uploaddetail.setOwner(androiddetail.getOwner());
            uploaddetail.setEktypcode(androiddetail.getEktyp_code());
            nea = BigDecimal(uploaddetail.getValue()) ;
            uploaddetail.setNea(nea);




            detail_id = dualRepository.getYdrGeneralSeqnextval();  // Παιρνω ID για να δωσω στo Detail Images γιατι αν παρει ID στη βαση επιστρεφει null
            uploaddetail.setId(detail_id);

            images = uploaddetail.getImages();
            if (images == null || images.isEmpty()) {  }
            else {
                for (int j = 0; j < images.size(); j++) {
                    images.get(j).setDetailid(detail_id);
                }
            }
            eService.saveAndroidUploadDetail(uploaddetail);


        }
            return_body = "ALL       "+ydrometra_all.toString()+"\n"+
                          "FOUND     "+ydrometra_good.toString()+"\n"+
                          "NOT FOUND "+ydrometra_bad.toString();


        return new ResponseEntity<String>(return_body,HttpStatus.CREATED);
    }
}