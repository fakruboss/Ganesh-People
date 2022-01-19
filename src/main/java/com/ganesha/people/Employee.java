package com.ganesha.people;

public interface Employee {

  int getEmployeeId();
  String getEmployeename();
  void setEmployeename(String name);
  EmployeeType getEmployeeType();
  int getWorkedDays();
  float availableVacationDays();
  void work(int daysWorked) throws Exception;

  void takeVacation(float vacationDays) throws Exception;
}