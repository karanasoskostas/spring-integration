package pydra.integration.Fconsumers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FconsumersRepository extends JpaRepository<Fconsumers, Long> {

}