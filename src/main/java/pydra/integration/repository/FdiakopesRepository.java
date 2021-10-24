package pydra.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.model.Fdiakopes;

import java.util.List;

@Repository
public interface FdiakopesRepository extends JpaRepository<Fdiakopes, Long> {

    @Query(value = "Select * from ydr_fdiakopes d where d.diakopes_status = 0 ",
           nativeQuery = true)
    List<Fdiakopes> getFdiakopesOpen();
}