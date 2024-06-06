/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

import java.util.Calendar;
import java.util.Date;

/**
 * Implementation of the {@link ContractEmployeeService} interface.
 * <p>
 * This class provides the implementation of methods to handle contract
 * employees, including calculating the renewal date and populating employee
 * data.
 * </p>
 *
 * @see ContractEmployeeService
 * @see Employee
 * @see ContractEmployee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class ContractEmployeeServiceImpl implements ContractEmployeeService {

    /**
     * Calculates the renewal date for a contract employee.
     *
     *
     * @return the renewal date, which is 1 year from today
     */
    @Override
    public Date renewalDate() {
        //f. Renewal date is only applicable for Contract Employees and is calculated 1 year from today.
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    /**
     * Populates the given contract employee with required data.
     *
     * @param employee the employee to populate
     */
    @Override
    public void populateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee should not be null!");
        }
        ContractEmployee ce = (ContractEmployee) employee;
        ce.setRenewalDate(renewalDate());
    }
}
