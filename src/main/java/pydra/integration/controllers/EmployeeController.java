package pydra.integration.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pydra.integration.model.Employee;
import pydra.integration.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.PrimitiveIterator;


//@Controller

@RestController    // @Controller + @ResponseBody
public class EmployeeController {



//    @Value("${app.name}")
//    private String appName;
//
//    @Value("${app.version}")
//    private String appVersion;
//
//    public EmployeeController() {
//    }
//
//    @GetMapping("/version")
//    public String getVersion(){
//        return appName+" "+appVersion+" ";
//    }

    @Autowired
    private EmployeeService eService;

//    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    @GetMapping("/employees")
//    @ResponseBody
//    public String getEmployees() {return "Display all Empoyees";}
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(eService.getEmployees() , HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee ){
        return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id , @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id){
        eService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
//                eService.deleteEmployee(id);
    }

    @GetMapping("/employees/findbyname/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/findlikename")
    public ResponseEntity<List<Employee>> getEmployeeLikeName(@RequestParam("name") String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesLikeNameIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping("/employees/findnamebetween")
    public ResponseEntity<List<Employee>> getEmployeeNameBetween(@RequestParam("fromname") String fromname, @RequestParam("toname") String toname){
        return new ResponseEntity<List<Employee>>(eService.getEmployeeNameBetween(fromname,toname), HttpStatus.OK);
    }

    @GetMapping("/employees/findbynameandlocation")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam("name") String name, @RequestParam("location") String location){
        return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
    }

}


