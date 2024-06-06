/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.employee.Employee;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Provides services for persisting employee data.
 * <p>
 * This class contains methods for saving employee data to a file using a
 * specified formatter.
 * </p>
 *
 * @see Employee
 * @see Formatter
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class PersistenceService {

    /**
     * Writes employee data to a file using the specified formatter.
     *
     * @param person
     * @param filename the name of the file to save the data to
     * @param formatter the formatter to use for formatting the employee data
     * @throws IOException if an I/O error occurs
     * @throws IllegalArgumentException if any of the parameters are null
     */
    public void saveEmployee(Employee person, String filename, Formatter formatter) throws IOException {
        if (person == null || filename == null || formatter == null) {
            throw new IllegalArgumentException("Parameters should not be null!");
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename,false))) {
            String personStr = formatter.format(person);
            System.out.println(personStr);
            writer.println(personStr);
            writer.flush();
        }
    }

}
