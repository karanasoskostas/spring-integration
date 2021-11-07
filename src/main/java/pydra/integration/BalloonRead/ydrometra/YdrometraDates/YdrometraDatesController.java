package pydra.integration.BalloonRead.ydrometra.YdrometraDates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pydra.integration.BalloonRead.ydrometra.YdrometraOnce.YdrometraOnce;
import pydra.integration.BalloonRead.ydrometra.YdrometraOnce.YdrometraOnceService;

import java.util.List;

@Controller
public class YdrometraDatesController {

    @Autowired
    private YdrometraDatesService eService;


    @GetMapping("/balloonread/ydrometra")
    ResponseEntity<List<YdrometraDates>> getAllagesDates(@RequestParam String fromdate, @RequestParam String todate){
        return new ResponseEntity<List<YdrometraDates>>(eService.getAllagesDates(fromdate,todate), HttpStatus.OK);
    }
}
