package com.ganesha.people.service;

import com.ganesha.people.EmployeeType;
import com.ganesha.people.HourlyEmployee;
import com.ganesha.people.IEmployee;
import com.ganesha.people.Manager;
import com.ganesha.people.SalariedEmployee;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  public IEmployee createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
    IEmployee employee;
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
//    return new Employee(employee.getEmployeeId(), employee.getEmployeeName(),
//        employee.getEmployeeType(), employee.getWorkedDays(), employee.availableVacationDays());
    return employee;
  }


  public IEmployee createEmployee(String name, EmployeeType employeeType) throws Exception {
    IEmployee employee;
    switch (employeeType) {
      case HOURLY:
        employee = new HourlyEmployee();
        employee.setEmployeeName(name);
        break;
      case SALARIED:
        employee = new SalariedEmployee();
        employee.setEmployeeName(name);
        break;
      case MANAGER:
        employee = new Manager();
        employee.setEmployeeName(name);
        break;
      default:
        // create a custom exception for invalid employee type
        throw new Exception();
    }
//    return new Employee(employee.getEmployeeId(), employee.getEmployeeName(),
//        employee.getEmployeeType(), employee.getWorkedDays(), employee.availableVacationDays());
    return employee;
  }
}