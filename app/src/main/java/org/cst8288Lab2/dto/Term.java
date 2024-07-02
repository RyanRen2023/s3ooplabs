/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Term Enum for Academic Terms
 */
package org.cst8288Lab2.dto;

/**
 * An enum representing the academic terms: WINTER, SUMMER, and FALL.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public enum Term {
    WINTER(1),
    SUMMER(2),
    FALL(3);

    private final int termNumber;

    /**
     * Private constructor for the Term enum.
     *
     * @param termNumber the number associated with the term
     */
    private Term(int termNumber) {
        this.termNumber = termNumber;
    }

    /**
     * Returns the number associated with the term.
     *
     * @return the term number
     */
    public int getTermNumber() {
        return termNumber;
    }

    /**
     * Returns the Term enum value corresponding to the specified term number.
     *
     * @param termNumber the number associated with the term
     * @return the Term enum value
     * @throws IllegalArgumentException if the term number is not supported
     */
    public static Term getTerm(int termNumber) {
        switch (termNumber) {
            case 1:
                return WINTER;
            case 2:
                return SUMMER;
            case 3:
                return FALL;
            default:
                throw new IllegalArgumentException("Unsupported arguments!");
        }
    }

    /**
     * Returns the Term enum value corresponding to the specified term name.
     *
     * @param term the name of the term
     * @return the Term enum value
     * @throws IllegalArgumentException if the term name is not supported
     */
    public static Term getTerm(String term) {
        if (term.equalsIgnoreCase(WINTER.name())) {
            return WINTER;
        }

        if (term.equalsIgnoreCase(SUMMER.name())) {
            return SUMMER;
        }

        if (term.equalsIgnoreCase(FALL.name())) {
            return FALL;
        }
        return null;
    }
}
