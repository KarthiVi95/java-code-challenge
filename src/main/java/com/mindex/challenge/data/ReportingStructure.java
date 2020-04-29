package com.mindex.challenge.data;

/**
 * @author Karthik Vikram
 * Custom ReportingStructure Object. Acts like a DTO.
 */
public class ReportingStructure {
	
	/** Its always good practice to have vars as private and access them
	through getters and setters **/
	private Employee employee;
	private int numOfReports;
	
	// Getter and setters for the two private properties follow.
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public int getNumOfReports() {
		return this.numOfReports;
	}
	
	public void setNumOfReports(int numOfReports) {
		this.numOfReports = numOfReports;
	}
}
