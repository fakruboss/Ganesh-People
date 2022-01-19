package com.ganesha.people.service;

import com.ganesha.people.HourlyEmployee;
import com.ganesha.people.Manager;
import com.ganesha.people.SalariedEmployee;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
    com.ganesha.people.Employee employee;
    switch (createEmployeeRequest.getEmployeeType()) {
      case HOURLY:
        employee = new HourlyEmployee();
        break;
      case SALARIED:
        employee = new SalariedEmployee();
        break;
      case MANAGER:
        employee = new Manager();
        break;
      default:
        // create a custom exception for invalid employee type
        throw new Exception();
    }
    return new Employee(employee.getEmployeeId());
  }
}