package pydra.integration.BalloonRead.ydrometra.Measurments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pydra.integration.exception.GeneralException;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementsServiceImpl implements MeasurmentsService{
    @Autowired
    private MeasurmentsRepository eRepository;

    @Override
    public List<Measurments> getMeasurementsByDate(String fromdate, String todate) {
        List<Measurments> measurements = null;
        try{
            measurements = eRepository.getMeasurementsByDate(fromdate, todate);
        }catch(Exception ex){
            throw new GeneralException("MeasurementsServiceImpl getMeasurementsByDate Exception :"+ex.getMessage());
        }
        if (measurements.isEmpty()){
            throw new GeneralException("Δεν Βρέθηκαν Εγγραφές");
        }

        return measurements;
    }
}
