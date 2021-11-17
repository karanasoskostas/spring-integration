package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploadmaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AndroiduploadmasterRepository extends JpaRepository<Androiduploadmaster, Long> {

    @Query("select a from Androiduploadmaster a where a.id = ?1")
    Androiduploadmaster getById(Long id);
}