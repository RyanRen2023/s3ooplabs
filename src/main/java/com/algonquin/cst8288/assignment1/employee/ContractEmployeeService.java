/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

import java.util.Date;

/**
 * Provides services specific to contract employees.
 * <p>
 * This interface extends the {@link EmployeeService} interface and adds a
 * method to get the renewal date for contract employees.
 * </p>
 *
 * @see EmployeeService
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public interface ContractEmployeeService extends EmployeeService {

    /**
     * Gets the renewal date for a contract employee.
     *
     * @return the renewal date for the contract employee
     */
        public Date renewalDate();

}
