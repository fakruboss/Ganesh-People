package com.ganesha.people.controller;

import com.ganesha.people.IEmployee;
import com.ganesha.people.datastore.EmployeeData;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.service.PeopleService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

  PeopleService peopleService;

  @Autowired
  PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @PostMapping("/employee/create")
  public ResponseEntity<IEmployee> addCard(
      @RequestBody CreateEmployeeRequest createEmployeeRequest) throws Exception {
    IEmployee employee = peopleService.createEmployee(createEmployeeRequest);
    EmployeeData.getInstance().addEmployee(employee.getEmployeeId(), employee);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/employee/{id}")
  public ResponseEntity<IEmployee> getEmployee(@PathVariable("id") int id) {
    IEmployee employee = EmployeeData.getInstance().getEmployee(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @GetMapping("/employees")
  public ResponseEntity<Map<Integer, IEmployee>> getEmployees() {
    Map<Integer, IEmployee> employeeMap = EmployeeData.getInstance().getEmployees();
    return new ResponseEntity<>(employeeMap, HttpStatus.OK);
  }
}