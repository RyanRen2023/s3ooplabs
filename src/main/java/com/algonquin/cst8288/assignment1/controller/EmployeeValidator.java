/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployee;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates Employee objects to ensure they meet certain criteria.
 * <p>
 * This class provides methods to validate the properties of an Employee object,
 * including name, email, salary, total compensation, and number of service
 * years.
 * </p>
 *
 * @see Employee
 * @see PermanentEmployee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class EmployeeValidator {

    /**
     * Validates the given Employee object.
     *
     * @param employee the Employee object to validate
     * @return true if the employee is valid, false otherwise
     */
    public boolean isValidEmployee(Employee employee) {
        if (!isPresent(employee.getName())) {
            return false;
        }

        if (!isValidAlphaNumeric(employee.getName())) {
            return false;
        }
        if (employee.getEmail() == null || employee.getEmail().trim().length() == 0) {
            return false;
        }
        if (!isValidEmail(employee.getEmail())) {
            return false;
        }

        if (!isNoSalary(employee.getSalary())) {
            return false;
        }
        if (employee instanceof PermanentEmployee) {
            if (!isNoCompensation(((PermanentEmployee) employee).getTotalCompensation())) {
                return false;
            }

            if (!isNoServiceYear(((PermanentEmployee) employee).getNumberOfServiceYear())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the given string is present (not null and not empty).
     *
     * @param value the string to check
     * @return true if the string is present, false otherwise
     */
    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }

    /**
     * Checks if the given string contains only alphanumeric characters.
     *
     * @param value the string to check
     * @return true if the string is alphanumeric, false otherwise
     */
    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    /**
     * Checks if the given string is a valid email address.
     *
     * @param value the email address to check
     * @return true if the email address is valid, false otherwise
     */
    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    /**
     * Checks if the given salary is greater than zero.
     *
     * @param salary the salary to check
     * @return true if the salary is greater than zero, false otherwise
     */
    private boolean isNoSalary(double salary) {
        return salary > 0;
    }

    /**
     * Checks if the given total compensation is greater than zero.
     *
     * @param compensation the total compensation to check
     * @return true if the total compensation is greater than zero, false
     * otherwise
     */
    private boolean isNoCompensation(double compensation) {
        return compensation > 0;
    }

   /**
     * Checks if the given number of service years is greater than zero.
     * 
     * @param serviceYear the number of service years to check
     * @return true if the number of service years is greater than zero, false otherwise
     */
    private boolean isNoServiceYear(int serviceYear) {
        return serviceYear > 0;
    }

}
