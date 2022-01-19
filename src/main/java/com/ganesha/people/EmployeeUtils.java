package com.ganesha.people;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeUtils {

  private static int employeeId = 0;

  // TODO : handle concurrency
  public int generateEmployeeId() {
    return ++employeeId;
  }
}