package com.ganesha.people;

import lombok.Getter;

public class HourlyEmployee implements IEmployee {

  private static final float MAX_VACATION_DAYS = 10;
  @Getter
  private final int employeeId;
  private String name = "";
  private float availedVacationDays = MAX_VACATION_DAYS;
  private int daysWorked = 0;

  public HourlyEmployee() {
    this.employeeId = EmployeeUtils.generateEmployeeId();
  }

  @Override
  public String getEmployeeName() {
    return this.name;
  }

  @Override
  public void setEmployeeName(String employeename) {
    this.name = employeename;
  }

  @Override
  public EmployeeType getEmployeeType() {
    return EmployeeType.HOURLY;
  }

  @Override
  public int getWorkedDays() {
    return this.daysWorked;
  }

  @Override
  public float availableVacationDays() {
    return this.availedVacationDays;
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