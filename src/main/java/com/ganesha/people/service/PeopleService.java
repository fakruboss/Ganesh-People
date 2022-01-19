package com.ganesha.people.service;

import com.ganesha.people.EmployeeType;
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
    return new Employee(employee.getEmployeeId(),employee.getEmployeename(),employee.getEmployeeType(),employee.getWorkedDays(),employee.availableVacationDays());
  }

  public Employee createEmployee(String name, EmployeeType employeeType) throws Exception {
    com.ganesha.people.Employee employee;
    switch (employeeType) {
      case HOURLY:
        employee = new HourlyEmployee();
        employee.setEmployeename(name);
        break;
      case SALARIED:
        employee = new SalariedEmployee();
        employee.setEmployeename(name);
        break;
      case MANAGER:
        employee = new Manager();
        employee.setEmployeename(name);
        break;
      default:
        // create a custom exception for invalid employee type
        throw new Exception();
    }
    return new Employee(employee.getEmployeeId(),employee.getEmployeename(),employee.getEmployeeType(),employee.getWorkedDays(),employee.availableVacationDays());
  }


}