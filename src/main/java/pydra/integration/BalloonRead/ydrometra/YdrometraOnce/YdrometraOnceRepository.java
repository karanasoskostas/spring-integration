package pydra.integration.BalloonRead.ydrometra.YdrometraOnce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pydra.integration.Dual.Dual;

import java.util.List;

public interface YdrometraOnceRepository extends JpaRepository<Dual, Long> {
    public static final String qry =
            "select ydr_fconsumers.id                                      as id, " +
                    "       ydr_fconsumers.rma_ydrom                               as code ,\n" +
                    "       ydr_fconsumers.rma_ydrom                               as serial_number,\n" +
                    "       decode(ydr_fconsumers.emr,1,'digital','analog')        as  type,\n" +
                    "       ydr_fconsumers.latitude                                as  latitude,\n" +
                    "       ydr_fconsumers.longitude                               as  longitude,\n" +
                    "       null                                                   as length,\n" +
                    "       YDR_FPERDIAM.RPDIAM_descr                              as diameter,\n" +
                    "       null                                                   as manufacturer,\n" +
                    "       null                                                   as model,\n" +
                    "       null                                                   as old_hydrometer,\n" +
                    "       null                                                   as movedate,\n" +
                    "       null                                                   as counter, \n" +
                    "       FN_FORMAT_DIADROMI(rma_code, snd_genpar.DIADROMH_FORMAT)  as kwdikos_katanalwti,\n" +
                    "       nvl(liable.rpe_lastname,' ')||' '||nvl(liable.RPE_FIRSTNAME,' ')  as contact ,\n" +
                    "       decode(rma_addr_odos_akin, \n" +
                    "              null , rma_perigr_addr , \n" +
                    "              trim(nvl(rad_address, ' ')) ||' '||nvl(to_char(rma_addr_no1_akin),' ') ||' '||nvl(to_char(rma_addr_no2_akin),' '))  As address,\n" +
                    "       rma_parathr                                             as description,\n" +
                    "       YDR_FSECTORS.SECT_DESCR                                 as sector\n" +
                    "                                                                                                                  \n" +
                    "from ydr_fconsumers LEFT OUTER JOIN YDR_FPERDIAM  ON (  ydr_fconsumers.RMA_DIAM_AGOG = YDR_FPERDIAM.RPDIAM_CODE)\n" +
                    "                    LEFT OUTER JOIN YDR_FPERSONS liable ON ( ydr_fconsumers.RMA_LIABLE_ID = liable.ID)\n" +
                    "                    LEFT OUTER JOIN YDR_FADDRESS ON ( ydr_fconsumers.RMA_ADDR_ODOS_AKIN = YDR_FADDRESS.ID ) \n" +
                    "                    inner join snd_genpar on (1=1)\n" +
                    "                    LEFT OUTER JOIN YDR_FSECTORS ON ( ydr_fconsumers.RMA_TOMEAS = YDR_FSECTORS.SECT_CODE) ";
    @Query(nativeQuery = true, value = qry)
    List<YdrometraOnce> getAllOnce();


}