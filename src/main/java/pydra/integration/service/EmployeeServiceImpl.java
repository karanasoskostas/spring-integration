package pydra.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pydra.integration.model.Employee;
import pydra.integration.repository.EmployeeRepository;
import pydra.integration.repository.PageSorting.EmployeePSRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Autowired
    private EmployeePSRepository epsRepository;

    @Override
    public List<Employee> getEmployees(){
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee =  eRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Not Found Employee with id "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);

    }

    @Override
    public List<Employee> getEmployeesLikeNameIgnoreCase(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return eRepository.findByNameContainingIgnoreCase(name, sort);
    }

    @Override
    public List<Employee> getEmployeeNameBetween(String fromname, String toname) {
        return eRepository.findByNameBetween(fromname,toname);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    // paging and sorting
    @Override
    public List<Employee> getpsEmployees(int pagenumber, int pagesize) {
        Pageable pages = PageRequest.of(pagenumber, pagesize, Sort.by("name").descending().and(Sort.by("id").ascending()));
        return epsRepository.findAll(pages).getContent();
    }

    @Override
    public List<Employee> getpsEmployeesSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"name");
        return epsRepository.findAll(sort);
        // ή return eRepository.findAll(sort);
    }

    @Override
    public Integer deleteByEmployeeId(Long id) {
        return eRepository.deleteByEmployeeId(id);
    }


}



