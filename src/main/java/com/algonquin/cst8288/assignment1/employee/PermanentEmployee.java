/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

/**
 * Represents a permanent employee with a fixed salary, a bonus, and a number of
 * service years.
 * <p>
 * This class extends the {@link Employee} class and adds specific attributes
 * and methods for permanent employees.
 * </p>
 *
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * @author Xihai Ren
 */
public class PermanentEmployee extends Employee {

    /**
     * The number of years the employee has been in service.
     */
    private int numberOfServiceYear;

    /**
     * The bonus awarded to the employee.
     */
    private double bonus;

    /**
     * The total compensation of the employee, including salary and bonus.
     */
    private double totalCompensation;

    /**
     * Constructs a new PermanentEmployee with the specified details.
     *
     * @param name the name of the employee
     * @param email the email of the employee
     * @param address the address of the employee
     * @param salary the salary of the employee
     * @param numberOfServiceYear the number of years the employee has been in
     * service
     */
    public PermanentEmployee(String name, String email, String address, double salary, int numberOfServiceYear) {
        super(name, email, address, salary);
        this.numberOfServiceYear = numberOfServiceYear;
    }

    /**
     * Gets the bonus of the employee.
     *
     * @return the bonus of the employee
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Sets the bonus of the employee.
     *
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * Gets the total compensation of the employee.
     *
     * @return the total compensation of the employee
     */
    public double getTotalCompensation() {
        return totalCompensation;
    }

    /**
     * Sets the total compensation of the employee.
     *
     * @param totalCompensation the total compensation to set
     */
    public void setTotalCompensation(double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }

    /**
     * Gets the number of years the employee has been in service.
     *
     * @return the number of years the employee has been in service
     */
    public int getNumberOfServiceYear() {
        return numberOfServiceYear;
    }

    /**
     * Sets the number of years the employee has been in service.
     *
     * @param numberOfServiceYear the number of years to set
     */
    public void setNumberOfServiceYear(int numberOfServiceYear) {
        this.numberOfServiceYear = numberOfServiceYear;
    }

    /**
     * Returns a string representation of the PermanentEmployee object.
     *
     * @return a string representation of the PermanentEmployee object
     */
    @Override
    public String toString() {
        return "PermanentEmployee [name=" + this.getName() + ", email=" + this.getEmail() + ", address=" + this.getAddress() + ", salary=" + this.getSalary()
                + ", numberOfServiceYear=" + this.getNumberOfServiceYear() + ", bonus=" + this.getBonus() + ", totalCompensation="
                + this.getTotalCompensation() + "]";
    }

}
