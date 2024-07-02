/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Validation Utility
 */
package org.cst8288Lab2.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.cst8288Lab2.dto.Term;

/**
 * A utility class for validating student and course data.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Validation {

    /**
     * Validates the student ID.
     *
     * @param studentId the student ID to validate
     * @return true if the student ID is valid, false otherwise
     */
    private static boolean validateStudentId(String studentId) {
        String regex = "\\d{9}";
        return null != studentId && String.valueOf(studentId).matches(regex);
    }

    /**
     * Validates the course ID.
     *
     * @param courseId the course ID to validate
     * @return true if the course ID is valid, false otherwise
     */
    private static boolean validateCourseId(String courseId) {
        String regex = "[a-zA-Z]{3}[0-9]{4}";
        return null != courseId && courseId.matches(regex);
    }

    /**
     * Validates the term number.
     *
     * @param termNo the term number to validate
     * @return true if the term number is valid, false otherwise
     */
    private static boolean validateTerm(int termNo) {
        return termNo >= 1 && termNo <= 3;
    }

    /**
     * Validates the year.
     *
     * @param year the year to validate
     * @return true if the year is valid, false otherwise
     */
    private static boolean validateYear(String year) {
        if (year == null || !year.matches("\\d{4}")) return false;
        int intYear = Integer.parseInt(year);
        int foundYear = 1967;
        int currYear = LocalDate.now().getYear();
        return intYear >= foundYear && intYear < currYear;
    }

    /**
     * Validates the provided student ID, course ID, term number, and year.
     *
     * @param studentId the student ID to validate
     * @param courseId the course ID to validate
     * @param termNo the term number to validate
     * @param year the year to validate
     * @return a Peer object containing a boolean indicating if all validations
     * passed, and a list of error messages
     */
    public Peer<Boolean, List<String>> validate(String studentId, String courseId, String termNo, String year) {
        List<String> errInfo = new ArrayList<>();
        boolean isStudentIdValid = validateStudentId(studentId);
        boolean isCourseIdValid = validateCourseId(courseId);
        boolean isTermValid = validateTerm(Term.getTerm(termNo) == null ? -1 : Term.getTerm(termNo).getTermNumber());
        boolean isYearValid = validateYear(year);
        if (!isStudentIdValid) {
            errInfo.add("StudentId should be length of 9 digits");
        }
        if (!isCourseIdValid) {
            errInfo.add("CourseId should be length of 7 characters (3 letters followed by 4 digits)");
        }
        if (!isTermValid) {
            errInfo.add("Term should be one of three options: “WINTER”, “SUMMER”, “FALL”");
        }
        if (!isYearValid) {
            errInfo.add("Year should be length of 4 digits and between 1967 and 2024.");
        }
        boolean isValid = isStudentIdValid && isCourseIdValid && isTermValid && isYearValid;
        return new Peer<>(isValid, errInfo);
    }
}
