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
 * Represents a contract employee with a renewal date.
 * <p>
 * This class extends the {@link Employee} class and adds specific attributes
 * and methods for contract employees.
 * </p>
 *
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class ContractEmployee extends Employee {

    /**
     * The date when the contract needs to be renewed.
     */
    private Date renewalDate;

    /**
     * Constructs a new ContractEmployee with the specified details.
     *
     * @param name the name of the employee
     * @param email the email of the employee
     * @param address the address of the employee
     * @param salary the salary of the employee
     */
    public ContractEmployee(String name, String email, String address, double salary) {
        super(name, email, address, salary);
    }

    /**
     * Gets the renewal date of the contract employee.
     *
     * @return the renewal date of the contract employee
     */
    public Date getRenewalDate() {
        return renewalDate;
    }

    /**
     * Sets the renewal date of the contract employee.
     *
     * @param renewalDate the renewal date to set
     */
    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    /**
     * Returns a string representation of the ContractEmployee object.
     *
     * @return a string representation of the ContractEmployee object
     */
    @Override
    public String toString() {
        return "ContractEmployee  [name=" + this.getName() + ", email=" + this.getEmail() + ", address=" + this.getAddress() + ", salary=" + this.getSalary()
                + ", renewalDate=" + this.getRenewalDate() + "]";
    }
}
