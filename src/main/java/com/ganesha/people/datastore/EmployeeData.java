package com.ganesha.people.datastore;

import com.ganesha.people.model.Employee;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeData {

  private static EmployeeData employeeData;
  private final Map<Integer, Employee> employeeMap = new HashMap<>();

  // TODO : handle synchronisation
  public static EmployeeData getInstance() {
    if (employeeData == null) {
      employeeData = new EmployeeData();
    }
    return employeeData;
  }

  public static Employee addEmployee(int empId, Employee employee) {
    return getDataMap().put(empId, employee);
  }

  public static Employee getEmployee(int empId) {
    return getDataMap().get(empId);
  }

  public static Map<Integer, Employee>  getEmployees() {
    return getDataMap();
  }

  public static Map<Integer, Employee> getDataMap() {
    return getInstance().getEmployeeMap();
  }
}
