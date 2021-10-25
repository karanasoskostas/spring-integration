package pydra.integration.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.Fperdiak.Fperdiak;

import java.util.List;

@Repository
public interface EidopRepositoryold extends JpaRepository<Fperdiak, Long> {


    @Query(nativeQuery = true,
            value = "SELECT ydr_fdiakopes.id          as id,\n" +
                    "       ydr_fdiakopes.RDIAK_EIDOS as eidos, \n" +
                    "       ydr_fperdiak.rpdiak_descr as descr \n" +
                        "   FROM ydr_fdiakopes inner join ydr_fperdiak on (ydr_fdiakopes.RDIAK_EIDOS = ydr_fperdiak.rpdiak_code)\n" +
                           "where ydr_fdiakopes.DIAKOPES_STATUS = 0")
        List<EidopModel> getEidopModel();
}