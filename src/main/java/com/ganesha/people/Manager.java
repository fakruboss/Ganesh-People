package com.ganesha.people;

import lombok.Getter;

public class Manager implements Employee {

  @Getter
  private final int employeeId;
  private static final float MAX_VACATION_DAYS = 10;
  private float availedVacationDays;
  private int daysWorked;

  public Manager() {
    this.employeeId = EmployeeUtils.generateEmployeeId();
  }

  @Override
  public void work(int daysWorked) throws Exception {

  }

  @Override
  public void takeVacation(float vacationDays) throws Exception {

  }
}