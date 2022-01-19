package com.ganesha.people.model;

import com.ganesha.people.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {

  private int employeeId;
  private String name;
  private EmployeeType employeeType;
  private int daysWorked;
  private float vacationDays;
}