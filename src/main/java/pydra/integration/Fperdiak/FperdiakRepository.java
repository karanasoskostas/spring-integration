package pydra.integration.Fperdiak;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pydra.integration.Fperdiak.Fperdiak;

@Repository
public interface FperdiakRepository extends JpaRepository<Fperdiak, Long> {

    @Query(value = "select RPDIAK_DESCR from ydr_fperdiak where RPDIAK_code = :code",
           nativeQuery = true   )
    String getFperdiakDescr(@Param("code") Long code);
}