/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

/**
 * Provides services specific to permanent employees.
 * <p>
 * This interface extends the {@link EmployeeService} interface and adds methods
 * for calculating total compensation, pension contribution, and bonus for
 * permanent employees.
 * </p>
 *
 * @see EmployeeService
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public interface PermanentEmployeeService extends EmployeeService {

    /**
     * Calculates the total compensation for the given permanent employee.
     *
     * @param employee the employee for whom the total compensation is to be
     * calculated
     * @return the total compensation for the employee
     */
    public double calculateTotalCompensation(Employee employee);

    /**
     * Calculates the pension contribution for the given permanent employee.
     *
     * @param employee the employee for whom the pension contribution is to be
     * calculated
     * @return the pension contribution for the employee
     */
    public double pensionContribution(Employee employee);

    /**
     * Calculates the bonus for the given permanent employee.
     *
     * @param employee the employee for whom the bonus is to be calculated
     * @return the bonus for the employee
     */
    public double calculateBonus(Employee employee);

}
