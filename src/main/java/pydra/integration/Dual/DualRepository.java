package pydra.integration.Dual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DualRepository extends JpaRepository<Dual, String> {
    @Query(value="select seq_ydr_general.nextval from dual", nativeQuery = true)
    Long getYdrGeneralSeqnextval();
}