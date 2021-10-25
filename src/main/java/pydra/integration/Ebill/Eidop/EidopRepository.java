package pydra.integration.Ebill.Eidop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.Dual.Dual;


import java.util.List;

@Repository
public interface EidopRepository extends JpaRepository<Dual, Long> {


        @Query(nativeQuery = true,
               value =
                       "SELECT   ydr_fapodeix.id                                                        as id,                 \n" +
                       "         FN_FORMAT_DIADROMI(rma_code, snd_genpar.DIADROMH_FORMAT)               as rmacode,            \n" +
                       "         ydr_fconsumers.rma_ydrom                                               as rmaydrom,           \n" +
                       "         rad_address||' '||rma_addr_no1_akin                                    as addressakin,        \n" +
                       "         l.rpe_afm                                                              as rpeafm,             \n" +
                       "         trim(to_char(rtr_trim,'99'))||'/'||trim(to_char(rtr_etos,'0000'))      as period,             \n" +
                       "         rtr_date_apo                                                           as rtrdateapo ,        \n" +
                       "         rtr_date_ews                                                           as rtrdateews          \n" +
                       "from ydr_fconsumers inner join ydr_faddress on (rma_addr_odos_akin = ydr_faddress.id)                  \n" +
                       "                    inner join ydr_ftran_h on (rtr_maa = ydr_fconsumers.id)                            \n" +
                       "                    inner join ydr_fapodeix on ydr_fapodeix.id=ydr_ftran_h.rtr_fapodeix_id             \n" +
                       "                    inner join ydr_rel_id on (ydr_fapodeix.id = ydr_rel_id.logar_id)                   \n" +
                       "                    left outer join ydr_fpersons l ON (ydr_fconsumers.rma_liable_id = l.id  )          \n" +
                       "                    left outer join ydr_fpersons o ON (ydr_fconsumers.rma_owner_id = o.id  )           \n" +
                       "                    left outer join ydr_ftameio_h  ON (ydr_fapodeix.rap_tam_id = ydr_ftameio_h.id )    \n" +
                       "                    inner join snd_genpar on (1=1)                                                     \n" +
                       "where (to_char( decode(ydr_fapodeix.rap_create_date,null,ydr_fapodeix.rap_date_ekd ,ydr_fapodeix.rap_create_date), 'yyyymmdd') between '20210901' and '20210901')"
        )
        List<Eidop> getEidopModel();
}