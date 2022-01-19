package com.ganesha.people;

import lombok.Getter;
import lombok.Setter;

public class SalariedEmployee implements IEmployee {

  private static final float MAX_VACATION_DAYS = 15;
  @Getter
  private final int employeeId;
  @Getter
  private float vacationDays = 0;
  @Getter
  @Setter
  private String employeeName = "";


  @Getter
  private int workedDays = 0;

  public SalariedEmployee() {
    this.employeeId = EmployeeUtils.generateEmployeeId();
  }

  @Override
  public EmployeeType getEmployeeType() {
    return EmployeeType.SALARIED;
  }

  @Override
  public void work(int daysWorked) throws Exception {
    if (daysWorked < 0 || daysWorked > 260 || this.workedDays + daysWorked > 260) {
      throw new Exception("Maximum working days already worked");
    }
    this.workedDays = this.workedDays + daysWorked;
  }

  @Override
  public void takeVacation(float vacationDays) throws Exception {
    boolean isVacationDaysRemaining =
        (this.vacationDays + vacationDays) <= MAX_VACATION_DAYS;
    if (this.vacationDays >= MAX_VACATION_DAYS || !isVacationDaysRemaining) {
      throw new Exception("No Vacation Days is available");
    }
    this.vacationDays = this.vacationDays + vacationDays;
  }
}