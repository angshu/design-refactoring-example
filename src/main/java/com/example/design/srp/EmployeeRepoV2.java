package com.example.design.srp;

import java.util.Optional;

public interface EmployeeRepoV2 {
    public Optional<Employee> getEmployeeById(String id);
    public void addEmployee(Employee employee);
}
