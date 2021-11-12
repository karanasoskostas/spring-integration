package pydra.integration.AndroidDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.AndroidDetail.Androiddetail;

import java.util.List;

@Repository
public interface AndroiddetailRepository extends JpaRepository<Androiddetail, Long> {

    List<Androiddetail> findByFileid(Long file_id);

    @Query("select a from Androiddetail a where a.fileid = ?1 and a.ydrometro = ?2")
    Androiddetail findByFileidAndYdrometro(Long file_id, String ydrometro);

}