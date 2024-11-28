package com.example.design.srp;

import jakarta.persistence.EntityNotFoundException;

public class SrpExampleV2 {
    EmployeeRepoV2 employeeRepo2;
    EmailSender mailSender;


    public void sendMail() {
        Employee employee = employeeRepo2.getEmployeeById("TW-12345").orElseThrow(EntityNotFoundException::new);
        mailSender.sendEmail(employee, new SimpleTextEmailContent("You are late to fill timesheet!"));
    }
}
