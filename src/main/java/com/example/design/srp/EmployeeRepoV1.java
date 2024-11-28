package com.example.design.srp;

import java.util.Optional;

public interface EmployeeRepoV1 {
    public Optional<Employee> getEmployeeById(String id);
    public void addEmployee(Employee employee);
    public void sendEmail(Employee employee, String content);
}

