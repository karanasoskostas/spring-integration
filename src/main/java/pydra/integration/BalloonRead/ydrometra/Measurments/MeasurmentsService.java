package pydra.integration.BalloonRead.ydrometra.Measurments;

import java.util.List;

public interface MeasurmentsService {
    List<Measurments> getMeasurementsByDate(String fromdate, String todate);
}
