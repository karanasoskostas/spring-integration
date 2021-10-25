package pydra.integration.Dual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DualRepository extends JpaRepository<Dual, String> {
}