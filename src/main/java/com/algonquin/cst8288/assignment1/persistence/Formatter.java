/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 * Defines a formatter interface for formatting employee data.
 * <p>
 * This interface provides a method to format an Employee object into a specific
 * format.
 * </p>
 *
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public interface Formatter {

    /**
     * Formats the given Employee object into a specific format.
     *
     * @param employee the employee object to format
     * @return the formatted representation of the employee object
     * @throws IOException if an error occurs during formatting
     */
    public String format(Employee employee) throws IOException;

}
