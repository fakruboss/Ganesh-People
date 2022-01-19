package com.ganesha.people;

import com.ganesha.people.datastore.EmployeeData;
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
    PeopleApplication.iniatizeEmployeeList();
  }

  public static void iniatizeEmployeeList() throws Exception {
    EmployeeType employeType = EmployeeType.HOURLY;
    for (int i = 0; i < 30; i++) {
      if (i > 9) {
        employeType = EmployeeType.SALARIED;
        if (i > 19) {
          employeType = EmployeeType.MANAGER;
        }
      }
      IEmployee employee = peopleService.createEmployee("", employeType);
      EmployeeData.getInstance().addEmployee(employee.getEmployeeId(), employee);
    }
  }
}