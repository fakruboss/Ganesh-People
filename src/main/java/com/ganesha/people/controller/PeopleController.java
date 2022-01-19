package com.ganesha.people.controller;

import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.model.Employee;
import com.ganesha.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @PostMapping("/create/employee")
  public ResponseEntity<Employee> addCard(
      @RequestBody CreateEmployeeRequest createEmployeeRequest) throws Exception {
    Employee employee = peopleService.createEmployee(createEmployeeRequest);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }
}