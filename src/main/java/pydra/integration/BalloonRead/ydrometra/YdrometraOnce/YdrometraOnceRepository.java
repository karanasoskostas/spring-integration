package pydra.integration.BalloonRead.ydrometra.YdrometraOnce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pydra.integration.Dual.Dual;

import java.util.List;

public interface YdrometraOnceRepository extends JpaRepository<Dual, Long> {
    public static final String qry =
            "select ydr_fconsumers.id                                      as id ,\n" +
                    "       trim(ydr_fconsumers.rma_ydrom)                         as code ,\n" +
                    "       trim(ydr_fconsumers.rma_ydrom)                         as serial_number,\n" +
                    "       decode(ydr_fconsumers.emr,1,'digital','analog')        as  type,\n" +
                    "       ydr_fconsumers.latitude                                as  latitude,\n" +
                    "       ydr_fconsumers.longitude                               as  longitude,\n" +
                    "       null                                                   as length,\n" +
                    "       YDR_FPERDIAM.RPDIAM_descr                              as diameter,\n" +
                    "       null                                                   as manufacturer,\n" +
                    "       null                                                   as model,\n" +
                    "       null                                                   as old_hydrometer,\n" +
                    "       to_char(                                                                 \n" +
                            "       nvl((select max(RYDR_DATE)                                               \n" +
            "                            from ydr_fydromet                                                   \n" +
            "                            where RYDR_MAA = ydr_fconsumers.id),ydr_fconsumers.rma_create_date) , \n" +
                    "              'yyyy-mm-dd hh:mm:ss')                                                   as movedate,\n" +
                    "       null                                                   as counter, \n" +
                    "       FN_FORMAT_DIADROMI(rma_code, snd_genpar.DIADROMH_FORMAT)  as kwdikos_katanalwti,\n" +
                    "       trim(nvl(liable.rpe_lastname,' ')||' '||nvl(liable.RPE_FIRSTNAME,' ')) as contact ,\n" +
                    "       trim(decode(rma_addr_odos_akin, \n" +
                    "              null , rma_perigr_addr , \n" +
                    "              trim(nvl(rad_address, ' ')) ||' '||nvl(to_char(rma_addr_no1_akin),' ') ||' '||nvl(to_char(rma_addr_no2_akin),' ')))  As address,\n" +
                    "       rma_parathr                                             as description,\n" +
                    "       YDR_FSECTORS.SECT_DESCR                                 as sector,\n" +
                    "       decode(ydr_fconsumers.RMA_STATUS,5,'SUSPENDED',9,'TERMINATED',1,'ACTIVE') as status \n"+
                    "                                                                                                                  \n" +
                    "from ydr_fconsumers LEFT OUTER JOIN YDR_FPERDIAM  ON (  ydr_fconsumers.RMA_DIAM_AGOG = YDR_FPERDIAM.RPDIAM_CODE)\n" +
                    "                    LEFT OUTER JOIN YDR_FPERSONS liable ON ( ydr_fconsumers.RMA_LIABLE_ID = liable.ID)\n" +
                    "                    LEFT OUTER JOIN YDR_FADDRESS ON ( ydr_fconsumers.RMA_ADDR_ODOS_AKIN = YDR_FADDRESS.ID ) \n" +
                    "                    inner join snd_genpar on (1=1)\n" +
                    "                    LEFT OUTER JOIN YDR_FSECTORS ON ( ydr_fconsumers.RMA_TOMEAS = YDR_FSECTORS.SECT_CODE) \n" +
                    "                    where exists ( select 1                                                              \n" +
                    "                                    from ydr_ftran_h                                                     \n" +
                    "                                    where rtr_maa =  ydr_fconsumers.id                                   \n" +
                    "                                      and rtr_etos >= 2016                                               \n" +
                    "                                      and rtr_tot_poso > 0 )                                             \n" +
                    "                                        ";
    @Query(nativeQuery = true, value = qry)
    List<YdrometraOnce> getAllOnce();


}