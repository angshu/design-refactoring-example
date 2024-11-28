package com.example.design.srp;

import java.util.Optional;

public class SrpExampleV1 {
    EmployeeRepoV1 employeeRepo;

    public void sendMail() {
        Optional<Employee> employee = employeeRepo.getEmployeeById("TW-12345");
        if (employee.isPresent()) {
            employeeRepo.sendEmail(employee.get(), "You are late to fill timesheet!");
        }
    }

}
