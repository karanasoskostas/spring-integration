package pydra.integration.repository.PageSorting;



import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pydra.integration.model.Employee;

import java.util.List;

@Repository
public interface EmployeePSRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findAll(Sort sort);



}