/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

/**
 * Provides services for handling employee data.
 * <p>
 * This interface defines methods for populating employee data.
 * </p>
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public interface EmployeeService {

    /**
     * Populates the given employee with required data.
     *
     * @param employee the employee to populate
     */
    public void populateEmployee(Employee employee);

}
