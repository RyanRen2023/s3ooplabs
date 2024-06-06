/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.employee.ContractEmployee;
import com.algonquin.cst8288.assignment1.employee.EmployeeServiceFactory;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployee;
import com.algonquin.cst8288.assignment1.persistence.PersistenceService;
import java.io.IOException;

/**
 * Main class to execute the application.
 * <p>
 * This class contains the main method which serves as the entry point for the
 * application. It instantiates employee objects and uses services to calculate
 * and populate data, then utilizes the EmployeeController to save the data in
 * both JSON and text formats.
 * </p>
 *
 * @see PermanentEmployee
 * @see ContractEmployee
 * @see EmployeeController
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Main {

    /**
     * The main method which serves as the entry point for the application.
     *
     * @param args command line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {

        // Instantiate two Employee objects and 
        // use PermanentEmployeeService.java and ContractEmployeeService.java to calculate and populate required data for objects
        // Utilize EmployeeController.java to save both objects in JSON and Text formats, 
        // saving the data in files named json_employee_data.txt and text_employee_data.txt.
        // Do the same thing to output the data to the console instead of saving it to a file.
        System.out.println("Begin to run main class");
        PermanentEmployee pEmployee = new PermanentEmployee("PermanentEmployee", "pEmployee@gmail.com", "8700 woodroffe", 100000.0, 5);
        ContractEmployee cEmployee = new ContractEmployee("ContractEmployee", "pEmployee@gmail.com", "8700 woodroffe", 100000.0);

        // initiate employeeController
        EmployeeValidator employeeValidator = new EmployeeValidator();
        PersistenceService persistenceService = new PersistenceService();
        EmployeeServiceFactory employeeServiceFactory = new EmployeeServiceFactory();
        EmployeeFormatter employeeFormatter = new EmployeeFormatter();
        EmployeeController employeeController = new EmployeeController(employeeValidator, persistenceService, employeeServiceFactory, employeeFormatter);

        // populate data in save as JSON and Text.
        employeeController.processEmployee(pEmployee);
        employeeController.processEmployee(cEmployee);

        System.out.println("finish  run main class");

    }

}
