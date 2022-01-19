package com.ganesha.people;

public interface IEmployee {

  int getEmployeeId();

  String getEmployeeName();

  void setEmployeeName(String name);

  EmployeeType getEmployeeType();

  int getWorkedDays();

  float availableVacationDays();

  void work(int daysWorked) throws Exception;

  void takeVacation(float vacationDays) throws Exception;
}