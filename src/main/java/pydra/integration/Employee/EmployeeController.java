package pydra.integration.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pydra.integration.exception.GeneralException;
import pydra.integration.exception.ErrorObject;

import java.util.List;


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
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee ){
        System.out.println("@PostMapping");
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

    @DeleteMapping("/employees/deletebyid")
    public ResponseEntity<Integer> deleteEmployeeById(@RequestParam("id") Long id){
        return new ResponseEntity<Integer>(eService.deleteByEmployeeId(id), HttpStatus.OK);
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

    // ---------------------------------------------------------------------------------------------------------------
    //  PAGING GET ALL
    @GetMapping("/employees/paging")
    public ResponseEntity<List<Employee>> getpsEmployees(@RequestParam int pagenumber, @RequestParam int pagesize) {
        return new ResponseEntity<List<Employee>>(eService.getpsEmployees(pagenumber,pagesize), HttpStatus.OK);
    }
    // ---------------------------------------------------------------------------------------------------------------
    //  SORTING ALL
    @GetMapping("/employees/sorted")
    public ResponseEntity<List<Employee>> getEmployeesSorted() {
        return new ResponseEntity<List<Employee>>(eService.getpsEmployeesSorted(), HttpStatus.OK);
    }
    // ---------------------------------------------------------------------------------------------------------------


    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(GeneralException ex){
        ErrorObject eobject = new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(eobject,HttpStatus.NOT_FOUND);
    }





}


