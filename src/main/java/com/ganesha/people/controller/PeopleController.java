package com.ganesha.people.controller;

import com.ganesha.people.IEmployee;
import com.ganesha.people.datastore.EmployeeData;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.service.PeopleService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeopleController {

  PeopleService peopleService;

  @Autowired
  PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @PostMapping("/create/employee")
  public ResponseEntity<IEmployee> createEmployee(
      @RequestBody CreateEmployeeRequest createEmployeeRequest) throws Exception {
    IEmployee employee = peopleService.createEmployee(createEmployeeRequest);
    EmployeeData.getInstance().addEmployee(employee.getEmployeeId(), employee);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/get/employee/{id}")
  public ResponseEntity<IEmployee> getEmployee(@PathVariable("id") int id) {
    IEmployee employee = EmployeeData.getInstance().getEmployee(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/list/employees")
  public ResponseEntity<Map<Integer, IEmployee>> getEmployees() {
    Map<Integer, IEmployee> employeeMap = EmployeeData.getInstance().getEmployees();
    return new ResponseEntity<>(employeeMap, HttpStatus.OK);
  }

  @RequestMapping(value={"/work/{id}","/work/{id}/{number}"},method= RequestMethod.POST)
  public ResponseEntity<IEmployee> workedDays(@PathVariable("id") int id,@RequestParam(value="number",required = false) String value) throws Exception {
    IEmployee employee = EmployeeData.getInstance().getEmployee(id);
    int workdays=1;
    if(value!=null){
      workdays=Integer.parseInt(value);
    }
    employee.work(workdays);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @RequestMapping(value={"/leave/{id}"},method= RequestMethod.POST)
  public ResponseEntity<IEmployee> leaveDays(@PathVariable("id") int id, @RequestParam(value="number",required = false) String value) throws Exception {
    IEmployee employee = EmployeeData.getInstance().getEmployee(id);
   float leavedays=1;
    if(value!=null){
      leavedays=Float.parseFloat(value);
   }
    employee.takeVacation(leavedays);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

}