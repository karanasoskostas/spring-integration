package pydra.integration.BalloonRead.ydrometra.Measurments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pydra.integration.Dual.Dual;

import java.util.List;

@Repository
public interface MeasurmentsRepository extends JpaRepository<Dual, String> {
    public static final String qry =
                    "select ydr_fconsumers.rma_ydrom                        as code,\n" +
                    "       to_char(ydr_ftran_h.rtr_date_metr,'yyyy-mm-yy') as metrdate,\n" +
                    "       ydr_ftran_h.rtr_nea                             as value,\n" +
                    "       ydr_fconsumers.latitude                         as latitude,\n" +
                    "       ydr_fconsumers.longitude                        as longitude,\n" +
                    "       FN_FORMAT_DIADROMI(rma_code, snd_genpar.DIADROMH_FORMAT)  as routelist\n" +
                    "from ydr_ftran_h inner join ydr_fconsumers on (ydr_ftran_h.rtr_maa = ydr_fconsumers.id)\n" +
                    "                 inner join snd_genpar on (1=1)\n" +
                    "where to_char(ydr_ftran_h.rtr_date_metr,'yyyymmdd') between :fromdate and :todate";
    @Query(nativeQuery = true,value = qry)
    List<Measurments> getMeasurementsByDate(@Param(value = "fromdate") String fromdate, @Param(value = "todate") String todate);



}