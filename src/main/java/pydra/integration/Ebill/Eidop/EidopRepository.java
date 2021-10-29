package pydra.integration.Ebill.Eidop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pydra.integration.Dual.Dual;


import java.util.List;

@Repository
public interface EidopRepository extends JpaRepository<Dual, Long> {


        @Query(nativeQuery = true,
               value =
                       "SELECT   ydr_fapodeix.id                                                        as id,                                                         \n" +
                       "         FN_FORMAT_DIADROMI(rma_code, snd_genpar.DIADROMH_FORMAT)               as rmacode,                                                     \n" +
                       "         ydr_fconsumers.rma_ydrom                                               as rmaydrom,                                                    \n" +
                       "         rad_address||' '||rma_addr_no1_akin                                    as addressakin,                                                 \n" +
                       "         l.rpe_afm                                                              as rpeafm,                                                      \n" +
                       "         trim(to_char(rap_trim,'99'))||'/'||trim(to_char(rap_etos,'0000'))      as period,                                                      \n" +
                       "         ydr_fapodeix_d.rapd_date_apo                                           as dateapo ,                                                    \n" +
                       "         ydr_fapodeix_d.rapd_date_ews                                           as dateews ,                                                    \n" +
                       "         ydr_fapodeix_d.rapd_nea - ydr_fapodeix_d.rapd_prohg                    as katkyb,                                                      \n" +
                       "         ydr_fapodeix_d.rapd_xre_kyb                                            as xrekyb,                                                      \n" +
                       "         ydr_fapodeix_d.rapd_tot_poso                                           as posotrexoysasperiodoy,                                                  \n" +
                       "         rma_syn_xre - rma_syn_pist                                             as ypoloipo ,                                                   \n" +
                       "         rma_timolog                                                            as rmatimolog,                                                  \n" +
                       "         (select count(*)                                                                                                                       \n" +
                       "         from ydr_ftran_h                                                                                                                       \n" +
                       "         where rtr_maa = ydr_fconsumers.id                                                                                                      \n" +
                       "          and rtr_date_orist is not null and rtr_tot_poso > rtr_plhr_poso)       as plhthosanexof,                                              \n" +
                       "         (select count(*) from ydr_ftran_h                                                                                                      \n" +
                       "          where rtr_maa = ydr_fconsumers.id                                                                                                     \n" +
                       "            and rtr_date_orist is not null                                                                                                      \n" +
                       "            and (trim(to_char(ydr_ftran_h.rtr_etos,'0000'))||trim(to_char(ydr_ftran_h.rtr_trim,'00')) <=                                        \n" +
                       "                 (trim(to_char(ydr_fapodeix.rap_etos,'0000'))||trim(to_char(ydr_fapodeix.rap_trim,'00')))))               as previousperiods,   \n" +
                       "         case rma_status                                                                                                                        \n" +
                       "              when 1 then 'ΕΝΕΡΓΟΣ'                                                                                                             \n" +
                       "              when 5 then 'ΔΙΑΚΟΠΗ'                                                                                                              \n" +
                       "              when 9 then 'ΕΞΑΓΩΓΗ'                                                                                                              \n" +
                       "         end                                                                     as status,                                                      \n" +
                       "         ydr_fconsumers.id                                                       as maa,                                                         \n" +
                       "         nvl(l.rpe_tel1,' ')                                                     as tel1,                                                        \n" +
                       "         nvl(l.rpe_tel2,' ')                                                     as tel2 ,                                                       \n" +
                       "         rad_perioxh                                                             as perioxh,                                                     \n" +
                       "         rad_polh                                                                as polh,                                                        \n" +
                       "         rma_dias                                                                as kodikospagias,                                               \n" +
                       "         rma_dias                                                                as kodikoshlektronikhs,                                         \n" +
                       "         ydr_fapodeix_d.rapd_nea                                                 as nea,                                                         \n" +
                       "         ydr_fapodeix_d.rapd_prohg                                               as prohg,                                                       \n" +
                       "         rap_date_ekd                                                            as dateekdoshs,                                                 \n" +
                       "         rap_date_lhxhs                                                          as datelhxh,                                                    \n" +
                       "         rma_syn_xre                                                             as synxre,                                                      \n" +
                       "         l.rpe_email                                                             as email,                                                       \n" +
                       "         l.rpe_mob_tel                                                           as mobtel,                                                      \n" +
                       "         l.rpe_lastname||' '|| nvl(l.rpe_firstname,' ')                          as liablename,                                                   \n" +
                       "         l.rpe_afm                                                               as liableafm,                                                    \n" +
                       "         o.rpe_lastname||' '|| nvl(o.rpe_firstname,' ')                          as ownername,                                                   \n" +
                       "         o.rpe_afm                                                               as ownerafm,                                                    \n" +
                       "         nvl(latitude,' ')                                                       as latitude,                                                    \n" +
                       "         nvl(longitude,' ')                                                      as longitude,                                                   \n" +
                       "         rap_date_ekd                                                            as eidopdateekd,                                                \n" +
                       "         ydr_rel_id.id                                                           as barcode ,                                                    \n" +
                       "         ydr_ftameio_h.rtamh_date_plhr                                           as eidopdateplhr  ,                                             \n" +
                       "         ydr_fapodeix.rap_create_date                                            as eidopcreatedate                                              \n" +
                "from ydr_fconsumers inner join ydr_faddress on (rma_addr_odos_akin = ydr_faddress.id)                                                                   \n" +
               "                     inner join ydr_fapodeix on (ydr_fapodeix.rap_rma_id=ydr_fconsumers.id )                                                             \n" +
               "                     inner join ydr_fapodeix_d on (ydr_fapodeix.id=ydr_fapodeix_d.RAPD_ID_H  and                                                         \n" +
                       "                                           ydr_fapodeix.rap_etos = ydr_fapodeix_d.rapd_etos and                                                  \n" +
                       "                                           ydr_fapodeix.rap_trim = ydr_fapodeix_d.rapd_trim )                                                    \n" +
                "                    inner join ydr_rel_id on (ydr_fapodeix.id = ydr_rel_id.logar_id)                                                                    \n" +
               "                     left outer join ydr_fpersons l ON (ydr_fconsumers.rma_liable_id = l.id  )                                                    \n" +
               "                     left outer join ydr_fpersons o ON (ydr_fconsumers.rma_owner_id = o.id  )                                                     \n" +
               "                     left outer join ydr_ftameio_h  ON (ydr_fapodeix.rap_tam_id = ydr_ftameio_h.id )                                              \n" +
               "                     inner join snd_genpar on (1=1)                                                                                               \n" +
                       "where (to_char( decode(ydr_fapodeix.rap_create_date,null,ydr_fapodeix.rap_date_ekd ,ydr_fapodeix.rap_create_date), 'yyyymmdd') between :fromdate and :todate) \n" +
                       " /*or  (                                                                                                                                           \n" +
                       "          (exists (select 1                                                                                                                      \n" +
                       "                  from ydr_ftran_pl  inner join ydr_fapodeix_d on (ydr_ftran_pl.RTP_ID_H = ydr_fapodeix_d.RAPD_FTRAN_ID)                         \n" +
                       "                  where ydr_fapodeix_d.RAPD_ID_H = ydr_fapodeix.id                                                                               \n" +
                       "                    and ydr_ftran_pl.RTP_DIAKANONISMOS_AA is null                                                                                \n" +
                       "                    and to_char(ydr_ftran_pl.RTP_DATE_PLHR, 'yyyymmdd') between :fromdate and :todate                                            \n" +
                       "                  )                                                                                                                              \n" +
                       "          )                                                                                                                                      \n" +
                       "   )*/"
        )
        List<Eidop> getEidopModel(@Param(value = "fromdate") String fromdate, @Param(value = "todate") String todate);
}