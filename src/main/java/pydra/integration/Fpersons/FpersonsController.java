package pydra.integration.Fpersons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FpersonsController {

    @Autowired
    private FpersonsService eService;

    @GetMapping("/fpersons/{id}")
    public ResponseEntity<Fpersons> getbyId(@PathVariable("id") Long id){
        return new ResponseEntity(eService.getSingleFpersons(id), HttpStatus.OK);

    }

}
