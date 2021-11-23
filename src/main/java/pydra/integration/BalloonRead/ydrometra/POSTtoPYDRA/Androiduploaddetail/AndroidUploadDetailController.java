package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import pydra.integration.AndroidMaster.Androidmaster;
import pydra.integration.AndroidMaster.AndroidmasterService;
import pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetailimages.Androiduploaddetailimages;
import pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploadmaster.Androiduploadmaster;
import pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploadmaster.AndroiduploadmasterService;
import pydra.integration.Dual.DualRepository;
import pydra.integration.Fkatamet.Fkatamet;
import pydra.integration.Fkatamet.FkatametService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private AndroidmasterService androidmasterService;
    @Autowired
    private AndroiduploadmasterService uploadmasterService;
    @Autowired
    private FkatametService fkatametService;

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
        AndroidUploadDetail uploaddetail , saveddetail;
        Androiddetail androiddetail;
        Androidmaster master ;
        Androiduploadmaster  savedmaster;
        Long file_id = 0L , ydrometra_good = 0L, ydrometra_bad = 0L ,  nea , detail_id;
        Integer ydrometra_all = 0;
        String ydrometro , return_body="" , user ="" , damages[], jsonimages[];
        List<Androiduploaddetailimages> images;
        Double d;
        Fkatamet fkatamet;
        HttpStatus httpstatus = HttpStatus.OK;

        ydrometra_all =  uploaddetaillist.size();

        if (uploaddetaillist.isEmpty()) {   // κενο detail τιποτα
            ydrometra_good = 0L;
            ydrometra_bad = 0L;
            ydrometra_all = 0;
            httpstatus = HttpStatus.NOT_FOUND;
        }

        for (int i=0; i< uploaddetaillist.size(); i++){
            uploaddetail = uploaddetaillist.get(i);
            file_id = uploaddetail.getRoutelist();

//            if (i == 0) {
//
//                Androiduploadmaster m = uploadmasterService.getById(file_id);  // αν υπαρχει ήδη το αρχειο δεν κανει τιποτα
//                if (m !=null){
//                    ydrometra_good = 0L;
//                    ydrometra_bad = 0L;
//                    ydrometra_all = 0;
//                    httpstatus = HttpStatus.CONFLICT;
//                    break;
//                }
//
//            }

            ydrometro = uploaddetail.getSerial_number();

            androiddetail = androiddetailService.findByFileIdnadYdrometro(file_id,ydrometro);
            if (androiddetail == null) {
                ydrometra_bad = ydrometra_bad + 1;
                continue;
            }
            // τα παδια του uploaddetail που δεν υπάρχουν εδω έρχονται απο το JSON (lat,long, dates ...)
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
            d = Double.parseDouble(uploaddetail.getValue());
            nea = d.longValue();
            uploaddetail.setNea(nea);
            user = uploaddetail.getUser();  //παίρνω το χρήστη απο το τελευταίο row , είναι ίδιος σε ολα , για το Master , είναι το emailaccount του καταμετρητή
            fkatamet = fkatametService.findByEmailaccount(user);
            if ( fkatamet != null ) {
                uploaddetail.setKatametrhths(fkatamet.getCode());
            }

            damages = uploaddetail.getDamage_type_code();   // Βλαβες ["1", "2"],
            if (damages != null) {
                for (int k = 0; k < damages.length; k++) {
                    if (k > 2) {
                        break;
                    }
                    if (k == 0) {
                        uploaddetail.setBlabh1(Long.valueOf(damages[k]).longValue());
                    }
                    if (k == 1) {
                        uploaddetail.setBlabh2(Long.valueOf(damages[k]).longValue());
                    }
                    if (k == 2) {
                        uploaddetail.setBlabh3(Long.valueOf(damages[k]).longValue());
                    }
                }
            }

            detail_id = dualRepository.getYdrGeneralSeqnextval();  // Παιρνω ID για να δωσω στo Detail Images γιατι αν παρει ID στη βαση επιστρεφει null
            uploaddetail.setId(detail_id);

            images = uploaddetail.getImages();
            if (images == null || images.isEmpty()) {  }
            else {
                for (int j = 0; j < images.size(); j++) {
                    images.get(j).setDetailid(detail_id);
                }
            }
            saveddetail = eService.saveAndroidUploadDetail(uploaddetail);
            if (saveddetail != null) {
                ydrometra_good = ydrometra_good + 1;
            }



        }

        if ( ydrometra_good > 0 ) {
            master = androidmasterService.getAndroidmasterById(file_id);
            if ( master != null) {
                Androiduploadmaster uploadmaster = new Androiduploadmaster();
                uploadmaster.setId(master.getId());
                uploadmaster.setSort_descr(master.getSort_descr());
                uploadmaster.setDescr(master.getDescr());
                uploadmaster.setTrim(master.getTrim());
                uploadmaster.setEtos(master.getEtos());
                uploadmaster.setTomeas(master.getTomeas());
                uploadmaster.setTomeas_descr(master.getTomeas_descr());
                uploadmaster.setFrom_code(master.getFrom_code());
                uploadmaster.setTo_code(master.getTo_code());
                uploadmaster.setCreate_date(master.getCreate_date());
                uploadmaster.setUsr(master.getUsr());
                uploadmaster.setCom(master.getCom());
                uploadmaster.setDeya_aa(master.getDeya_aa());
                uploadmaster.setUpload_date(new Date(System.currentTimeMillis()));
                uploadmaster.setUsr(user);

                savedmaster = uploadmasterService.saveAndroidUploadMaster(uploadmaster);
            }
        }

//        return_body = "ALL       "+ydrometra_all.toString()+"\n"+
//                      "SAVED     "+ydrometra_good.toString()+"\n"+
//                      "NOT FOUND "+ydrometra_bad.toString();


        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("ALL", ydrometra_all.toString());
        objectNode.put("SAVED", ydrometra_good.toString());
        objectNode.put("NOT FOUND", ydrometra_bad.toString());
        return_body = objectNode.toString();


        return new ResponseEntity<String>(return_body,httpstatus);
    }
}
