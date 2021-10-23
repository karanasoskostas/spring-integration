package pydra.integration.service;

import pydra.integration.model.Employee;
import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployees() ;

    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesLikeNameIgnoreCase(String name);

    List<Employee> getEmployeeNameBetween(String fromname, String toname);

    List<Employee> getEmployeeByNameAndLocation(String name, String location);


}
