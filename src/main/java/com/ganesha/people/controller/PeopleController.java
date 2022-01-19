package com.ganesha.people.controller;

import com.ganesha.people.IEmployee;
import com.ganesha.people.datastore.EmployeeData;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.model.Employee;
import com.ganesha.people.service.PeopleService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

  PeopleService peopleService;

  @Autowired
  PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @PostMapping("/create/employee")
  public ResponseEntity<Employee> createEmployee(
      @RequestBody CreateEmployeeRequest createEmployeeRequest) throws Exception {
    Employee employee = peopleService.createEmployee(createEmployeeRequest);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/get/employee/{id}")
  public ResponseEntity<IEmployee> getEmployee(@PathVariable("id") int id) {
    IEmployee employee = EmployeeData.getEmployee(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/list/employees")
  public ResponseEntity<Map<Integer, IEmployee>> getEmployees() {
    Map<Integer, IEmployee> employeeMap = EmployeeData.getEmployees();
    return new ResponseEntity<>(employeeMap, HttpStatus.OK);
  }

  @PostMapping(value = {"/work/{id}", "/work/{id}"})
  public ResponseEntity<IEmployee> workedDays(
      @PathVariable("id") int id,
      @RequestParam(value = "days", required = false) Integer days) throws Exception {
    IEmployee employee = EmployeeData.getEmployee(id);
    int workdays = days != null ? days : 1;
    employee.work(workdays);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping(value = {"/leave/{id}"})
  public ResponseEntity<IEmployee> leaveDays(@PathVariable("id") int id,
      @RequestParam(value = "days", required = false) Float days) throws Exception {
    IEmployee employee = EmployeeData.getEmployee(id);
    float leaveDays = days != null ? days : 1f;
    employee.takeVacation(leaveDays);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }
}