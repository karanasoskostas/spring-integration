package pydra.integration.Employee;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pydra.integration.Employee.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    @Query("select e from Employee e where upper(e.name) like upper(concat('%', ?1, '%'))")
    List<Employee> findByNameContainingIgnoreCase(String name, Sort sort);

//    @Query("select e from Employee e where e.name like %:name%")
//    List<Employee> findByNameContains(@Param("name") String name);
    @Query("select e from Employee e where e.name between ?1 and ?2")
    List<Employee> findByNameBetween(String fromname, String toname );

    // select * from Employee where name="" and location=""
    List<Employee> findByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("delete from Employee where id = :id")
    int deleteByEmployeeId(Long id);
}