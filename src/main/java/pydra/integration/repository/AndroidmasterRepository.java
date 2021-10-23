package pydra.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.model.Androidmaster;

@Repository
public interface AndroidmasterRepository extends JpaRepository<Androidmaster, Long> {



}
