package com.ganesha.people;

public interface Employee {

  int getEmployeeId();

  void work(int daysWorked) throws Exception;

  void takeVacation(float vacationDays) throws Exception;
}