package com.ganesha.people;

import lombok.Getter;

public class SalariedEmployee implements IEmployee {

  private static final float MAX_VACATION_DAYS = 15;
  @Getter
  private final int employeeId;
  private String name = "";
  private float availedVacationDays = MAX_VACATION_DAYS;
  private int daysWorked = 0;

  public SalariedEmployee() {
    this.employeeId = EmployeeUtils.generateEmployeeId();
  }

  @Override
  public String getEmployeeName() {
    return this.name;
  }

  @Override
  public void setEmployeeName(String name) {
    this.name = name;
  }

  @Override
  public EmployeeType getEmployeeType() {
    return EmployeeType.SALARIED;
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
