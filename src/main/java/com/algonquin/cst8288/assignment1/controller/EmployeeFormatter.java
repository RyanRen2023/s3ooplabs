/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 * Provides utility methods for formatting employee string data.
 * <p>
 * This class includes methods to trim whitespace from employee attributes.
 * </p>
 *
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class EmployeeFormatter {

    /**
     * Formats the given employee's name and email by trimming whitespace.
     *
     * @param employee the employee whose attributes will be formatted
     */
    public void formatString(Employee employee) {
        if (employee != null) {
            employee.setName(trim(employee.getName()));
            employee.setEmail(trim(employee.getEmail().trim()));
        }
    }

    /**
     * Trims whitespace from the given string.
     *
     * @param str the string to be trimmed
     * @return the trimmed string, or null if the input string was null
     */
    public static String trim(String str) {
        return str == null ? str : str.trim();
    }

}
