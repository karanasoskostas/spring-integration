package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AndroidDetailPostRepository extends JpaRepository<AndroidDetailPost, Long> {

    @Query("select a from AndroidDetailPost a where a.file_id = ?1")
    List<AndroidDetailPost> findByFile_id(Long file_id);

}