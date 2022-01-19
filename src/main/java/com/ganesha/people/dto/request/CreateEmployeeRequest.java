package com.ganesha.people.dto.request;

import com.ganesha.people.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateEmployeeRequest {

  String name;
  EmployeeType employeeType;
}