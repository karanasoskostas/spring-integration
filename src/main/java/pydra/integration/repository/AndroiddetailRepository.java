package pydra.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.model.Androiddetail;

import java.util.List;

@Repository
public interface AndroiddetailRepository extends JpaRepository<Androiddetail, Long> {

    List<Androiddetail> findByFileid(Long file_id);
}