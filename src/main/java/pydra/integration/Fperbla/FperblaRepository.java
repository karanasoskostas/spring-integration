package pydra.integration.Fperbla;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FperblaRepository extends JpaRepository<Fperbla, Long> {

    List<Fperbla> findAll();
}