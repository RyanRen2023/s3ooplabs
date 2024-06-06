/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * An implementation for formatting the data in JSON format.
 * <p>
 * This class provides a method to convert an Employee object into its JSON
 * representation.
 * </p>
 *
 * @see Formatter
 * @see Employee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class JSONFormatter implements Formatter {

     /**
     * Converts the given Employee object to its JSON representation.
     *
     * @param person the employee object to format
     * @return the JSON representation of the employee object
     * @throws IOException if an error occurs during JSON processing
     */
    @Override
    public String format(Employee person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

}
