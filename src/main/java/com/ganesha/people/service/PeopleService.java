package com.ganesha.people.service;

import com.ganesha.people.EmployeeType;
import com.ganesha.people.HourlyEmployee;
import com.ganesha.people.IEmployee;
import com.ganesha.people.Manager;
import com.ganesha.people.SalariedEmployee;
import com.ganesha.people.datastore.EmployeeData;
import com.ganesha.people.dto.request.CreateEmployeeRequest;
import com.ganesha.people.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) throws Exception {
    return createEmployee(createEmployeeRequest.getName(), createEmployeeRequest.getEmployeeType());
  }

  public Employee createEmployee(String name, EmployeeType employeeType) throws Exception {
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
    EmployeeData.addEmployee(employee.getEmployeeId(), employee);
    return Employee.builder()
        .employeeId(employee.getEmployeeId())
        .name(employee.getEmployeeName())
        .employeeType(employee.getEmployeeType())
        .daysWorked(employee.getWorkedDays())
        .vacationDays(employee.getVacationDays())
        .build();
  }
}