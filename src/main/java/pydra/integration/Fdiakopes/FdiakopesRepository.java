package pydra.integration.Fdiakopes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.Fdiakopes.Fdiakopes;

import java.util.List;

@Repository
public interface FdiakopesRepository extends JpaRepository<Fdiakopes, Long> {

    @Query(value = "Select * from ydr_fdiakopes d where d.diakopes_status = 0 and RDIAK_DATE_EPAN is null ",
           nativeQuery = true)
    List<Fdiakopes> getFdiakopesOpen();
}