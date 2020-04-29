package com.mindex.challenge.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;


@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure calculateReportingStructure(String employeeId) {
        Employee employee = employeeService.read(employeeId);
        LOG.debug("Calculating reportingStructure for employee [{}]", employee);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        reportingStructure.setNumOfReports(calculateNumOfReports(employee));
        return reportingStructure;
    }

    /**
     * This function calculates the number of distinct reports under a given employee. It
     * includes both direct and indirect employee.
     *
     * @param employee - The employee for whom no. of reports is calculated 
     * @return - Result of calculation is returned as integer
     */
    private int calculateNumOfReports(Employee employee) {
        int numOfReports = 0;
        
        // Iteratively calculating number of sub-employees under current employee.
        // Iteration is used to avoid internal call stack memory overflow in production level code.
        
        //LinkedList impl is faster than arraylist since a lot of add/removal is done
        Queue<Employee> recQueue = new LinkedList<Employee>();
        recQueue.offer(employee);
        while(!recQueue.isEmpty()) {
        	List<Employee> empList=getDirectReportsEmpId(recQueue.poll().getEmployeeId());
        	if(empList!=null) {
        	recQueue.addAll(empList);
        	}
        	numOfReports++;
        }
        return numOfReports-1;
    }
    
    /**
     * This function gives a list of employee objects who directly report under the 
     * given employeeId.
     * 
     * @param employeeId - Id of employee for whom directReports are needed
     * @return - List of Employee objects under the given employee
     */
    private List<Employee> getDirectReportsEmpId(String employeeId) {
    	Employee employee = employeeService.read(employeeId);
    	return employee.getDirectReports();
    }
}
