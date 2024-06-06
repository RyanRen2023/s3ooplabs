/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
    package com.algonquin.cst8288.assignment1.employee;

/**
 * Represents an employee with a name, email, address, and salary.
 * <p>
 * This class provides the basic attributes and methods for an employee.
 * </p>
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Employee {

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The email of the employee.
     */
    private String email;

    /**
     * The address of the employee.
     */
    private String address;

    /**
     * The salary of the employee.
     */
    private double salary;

    /**
     * Default constructor.
     */
    public Employee() {
        // Default constructor
    }

    /**
     * Constructs a new Employee with the specified details.
     *
     * @param name the name of the employee
     * @param email the email of the employee
     * @param address the address of the employee
     * @param salary the salary of the employee, must be greater than 0
     * @throws IllegalArgumentException if salary is less than or equal to 0
     */
    public Employee(String name, String email, String address, double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary should be greater than 0!");
        }
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the employee.
     *
     * @return the email of the employee
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the employee.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address of the employee.
     *
     * @return the address of the employee
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the employee.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary the salary to set, must be greater than 0
     * @throws IllegalArgumentException if salary is less than or equal to 0
     */
    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary should be greater than 0!");
        }
        this.salary = salary;
    }

    /**
     * Returns a string representation of the Employee object.
     *
     * @return a string representation of the Employee object
     */
    @Override
    public String toString() {
        return "Employee [name=" + name + ", email=" + email + ", address=" + address + ", salary=" + salary + "]";
    }

}
