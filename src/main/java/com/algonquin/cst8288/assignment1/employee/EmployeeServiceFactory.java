/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.employee;

/**
 * Factory class to create appropriate EmployeeService instances.
 * <p>
 * This class provides a method to create instances of {@link EmployeeService}
 * based on the type of employee.
 * </p>
 *
 * @see EmployeeService
 * @see PermanentEmployeeServiceImpl
 * @see ContractEmployeeServiceImpl
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class EmployeeServiceFactory {

    /**
     * Creates an instance of {@link EmployeeService} based on the type of
     * employee.
     *
     * @param employee the employee for which the service needs to be created
     * @return an instance of EmployeeService if the employee type is
     * recognized, null otherwise
     */
    public EmployeeService createService(Employee employee) {
        if (employee instanceof PermanentEmployee) {
            return new PermanentEmployeeServiceImpl();
        } else if (employee instanceof ContractEmployee) {
            return new ContractEmployeeServiceImpl();
        }
        return null;
    }

}
