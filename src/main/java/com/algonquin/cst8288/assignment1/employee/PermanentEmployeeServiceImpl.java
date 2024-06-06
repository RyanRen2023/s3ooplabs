/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

import com.algonquin.cst8288.assignment1.controller.Rate;

/**
 * Implementation of the {@link PermanentEmployeeService} interface.
 * <p>
 * This class provides methods to calculate total compensation, pension
 * contribution, and bonus for permanent employees, and to populate employee
 * data.
 * </p>
 *
 * @see PermanentEmployeeService
 * @see Employee
 * @see PermanentEmployee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class PermanentEmployeeServiceImpl implements PermanentEmployeeService {

    /**
     * Calculates the total compensation for the given permanent employee.
     *
     *
     * @param employee the employee for whom the total compensation is to be
     * calculated
     * @return the total compensation for the employee, or 0.0 if the employee
     * is null
     */
    @Override
    public double calculateTotalCompensation(Employee employee) {
        //b. Total compensation is calculated as salary + bonus.
        if (employee == null) {
            return 0.0;
        }
        return employee.getSalary() + this.calculateBonus(employee);
    }

    /**
     * Calculates the pension contribution for the given permanent employee.
     *
     *
     * @param employee the employee for whom the pension contribution is to be
     * calculated
     * @return the pension contribution for the employee, or 0.0 if the employee
     * is null
     */
    @Override
    public double pensionContribution(Employee employee) {
        //e. Pension contribution is 1% of base salary.
        if (employee == null) {
            return 0.0;
        }

        return employee.getSalary() * Rate.PENSION_PERCENTAGE;
    }

    /**
     * Calculates the bonus for the given permanent employee.
     *
     *
     * @param employee the employee for whom the bonus is to be calculated
     * @return the bonus for the employee, or 0.0 if the employee is null
     */
    @Override
    public double calculateBonus(Employee employee) {
        //d. Bonus is 2.5% of base salary and calculated multiplying by the years of service.
        if (employee == null) {
            return 0.0;
        }
        PermanentEmployee pe = (PermanentEmployee) employee;
        double bonus = pe.getSalary() * Rate.BONUS_PERCENTAGE * pe.getNumberOfServiceYear();
        return bonus;
    }

    /**
     * Populates the given permanent employee with required data.
     *
     *
     * @param employee the employee to populate
     * @throws IllegalArgumentException if the employee is null
     */
    @Override
    public void populateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee should not be null");
        }
        PermanentEmployee pe = (PermanentEmployee) employee;
        pe.setBonus(this.calculateBonus(employee));
        pe.setTotalCompensation(this.calculateTotalCompensation(employee));
    }

}
