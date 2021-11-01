package pydra.integration.Fconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FconsumersController {

    @Autowired
    private FconsumersService eService;

    @GetMapping("/fconsumers/{id}")
    public ResponseEntity<Fconsumers> getConsumerbyId(@PathVariable("id") Long id){
        return new ResponseEntity<>(eService.getSingleFconsumer(id), HttpStatus.OK);
    }
}
