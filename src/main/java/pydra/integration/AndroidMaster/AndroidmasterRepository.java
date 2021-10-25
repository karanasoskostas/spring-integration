package pydra.integration.AndroidMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.AndroidMaster.Androidmaster;

@Repository
public interface AndroidmasterRepository extends JpaRepository<Androidmaster, Long> {



}
