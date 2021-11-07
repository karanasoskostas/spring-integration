package pydra.integration.BalloonRead.ydrometra.Measurments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MeasurementsController {

    @Autowired
    private MeasurmentsService eService;

    @GetMapping("balloonread/measurements")
    public ResponseEntity<List<Measurments>> getMeasurementsByDate(@Param(value="fromdate") String fromdate, @Param(value="todate") String todate){
        return new ResponseEntity<List<Measurments>>(eService.getMeasurementsByDate(fromdate,todate), HttpStatus.OK);
    }
}
