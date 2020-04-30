package com.mindex.challenge.data;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Compensation")
public class Compensation {
	
	private String employeeId;
    private Employee employee;
    private double salary;
    private Date effectiveDate;

    public Compensation() {
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployee(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
