/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.employee.ContractEmployee;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployee;
import java.io.IOException;
import java.util.Date;

/**
 * An implementation for formatting the data in a text format.
 * <p>
 * This class provides methods to convert Employee objects into a formatted string representation.
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
public class TextFormatter implements Formatter {

    /**
     *
     * this method is responsible for saving the Employee object as key-value
     * pairs, such as (name=xxxx, email=xyz@abc.com)
     *
     * @param employee
     * @return formatted String.
     * @throws IOException
     */
    @Override
    public String format(Employee employee) throws IOException {
        String format;

        if (employee instanceof PermanentEmployee) {
            PermanentEmployee pe = (PermanentEmployee) employee;
            format = "(name=%s,email=%s,address=%s,salary=%.2f,numberOfServiceYear=%d,bonus=%.2f,totalCompensation=%.2f)";
            return String.format(format, pe.getName(), employee.getEmail(), employee.getAddress(), employee.getSalary(),
                    pe.getNumberOfServiceYear(), pe.getBonus(), pe.getTotalCompensation());
        } else if (employee instanceof ContractEmployee) {
            Date renewDate = ((ContractEmployee) employee).getRenewalDate();
            format = "(name=%s,email=%s,address=%s,salary=%.2f,renewalDate=%tb %te, %tY)";
            return String.format(format, employee.getName(), employee.getEmail(), employee.getAddress(), employee.getSalary(), renewDate, renewDate, renewDate);
        } else {
            format = "(name=%s,email=%s,address=%s,salary=%.2f)";
            return String.format(format, employee.getName(), employee.getEmail(), employee.getAddress(), employee.getSalary());
        }

    }

}
