package pydra.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.model.Fperdiak;

@Repository
public interface FperdiakRepository extends JpaRepository<Fperdiak, Long> {
}