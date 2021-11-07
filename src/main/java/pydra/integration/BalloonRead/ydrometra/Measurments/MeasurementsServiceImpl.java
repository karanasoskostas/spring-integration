package pydra.integration.BalloonRead.ydrometra.Measurments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementsServiceImpl implements MeasurmentsService{
    @Autowired
    private MeasurmentsRepository eRepository;

    @Override
    public List<Measurments> getMeasurementsByDate(String fromdate, String todate) {
        return eRepository.getMeasurementsByDate(fromdate, todate);
    }
}
