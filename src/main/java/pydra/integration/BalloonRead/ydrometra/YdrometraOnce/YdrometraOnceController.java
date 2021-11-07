package pydra.integration.BalloonRead.ydrometra.YdrometraOnce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class YdrometraOnceController {

    @Autowired
    private YdrometraOnceService eService;

    @GetMapping("/balloonread/ydrometraonce")
    public ResponseEntity<List<YdrometraOnce>>  getAllOnce(){
        return new ResponseEntity<List<YdrometraOnce>>(eService.getAllOnce(), HttpStatus.OK);
    }
}
