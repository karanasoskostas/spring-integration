package pydra.integration.Fkatamet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FkatametRepository extends JpaRepository<Fkatamet, Long> {

    @Query("select f from Fkatamet f where f.emailaccount = ?1")
    Fkatamet findByEmailaccount(String emailaccount);
}