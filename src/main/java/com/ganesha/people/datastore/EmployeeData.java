package com.ganesha.people.datastore;

import com.ganesha.people.IEmployee;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeData {

  private static EmployeeData employeeData;
  private final Map<Integer, IEmployee> employeeMap = new HashMap<>();

  // TODO : handle synchronisation
  public static EmployeeData getInstance() {
    if (employeeData == null) {
      employeeData = new EmployeeData();
    }
    return employeeData;
  }

  public static IEmployee addEmployee(int empId, IEmployee employee) {
    return getDataMap().put(empId, employee);
  }

  public static IEmployee getEmployee(int empId) {
    return getDataMap().get(empId);
  }

  public static Map<Integer, IEmployee> getEmployees() {
    return getDataMap();
  }

  public static Map<Integer, IEmployee> getDataMap() {
    return getInstance().getEmployeeMap();
  }
}
