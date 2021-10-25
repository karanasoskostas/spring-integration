package pydra.integration.Employee;



import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.Employee.Employee;

import java.util.List;

@Repository
public interface EmployeePSRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findAll(Sort sort);



}