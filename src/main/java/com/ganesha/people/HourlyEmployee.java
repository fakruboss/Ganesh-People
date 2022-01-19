package com.ganesha.people;

import lombok.Getter;

public class HourlyEmployee implements Employee {

  @Getter
  private final int employeeId;
  private static final float MAX_VACATION_DAYS = 10;
  private float availedVacationDays;
  private int daysWorked;

  public HourlyEmployee() {
    this.employeeId = EmployeeUtils.generateEmployeeId();
  }

  @Override
  public void work(int daysWorked) throws Exception {
    if (daysWorked < 0 || daysWorked > 260) {
      throw new Exception();
    }
    this.daysWorked = daysWorked;
  }

  @Override
  public void takeVacation(float vacationDays) throws Exception {
    this.availedVacationDays = availedVacationDays + vacationDays;
    if (this.availedVacationDays > MAX_VACATION_DAYS) {
      throw new Exception();
    }
  }
}