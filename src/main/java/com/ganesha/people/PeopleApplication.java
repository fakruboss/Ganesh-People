package com.ganesha.people;

import com.ganesha.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleApplication {

  static PeopleService peopleService;

  @Autowired
  PeopleApplication(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(PeopleApplication.class, args);
    PeopleApplication.initializeEmployeeList();
  }

  public static void initializeEmployeeList() throws Exception {
    initializeEmployees(EmployeeType.HOURLY);
    initializeEmployees(EmployeeType.SALARIED);
    initializeEmployees(EmployeeType.MANAGER);
  }

  private static void initializeEmployees(EmployeeType employeeType) throws Exception {
    for (int i = 1; i <= 10; i++) {
      peopleService.createEmployee(employeeType.name() + "-" + i, employeeType);
    }
  }
}