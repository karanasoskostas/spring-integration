package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndroidUploadDetailRepository extends JpaRepository<AndroidUploadDetail, Long> {
}