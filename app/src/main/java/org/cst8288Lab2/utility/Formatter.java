/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - String Formatter Utility
 */
package org.cst8288Lab2.utility;

/**
 * A utility class for formatting strings.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Formatter {

    /**
     * Trims leading and trailing whitespace from each string in the provided
     * array.
     *
     * @param content an array of strings to be trimmed
     * @return the trimmed array of strings
     */
    public String[] listStringFormat(String[] content) {
        for (int i = 0; i < content.length; i++) {
            content[i] = content[i].trim();
        }
        return content;
    }
}
