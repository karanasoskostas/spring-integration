package pydra.integration.Com_parms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparmsRepository extends JpaRepository<Comparms, Long> {
}