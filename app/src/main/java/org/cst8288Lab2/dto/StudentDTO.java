/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Transfer Object for Student
 */

package org.cst8288Lab2.dto;

/**
 * A Data Transfer Object (DTO) class for representing a student.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class StudentDTO {
    private Integer studentId;
    private String firstName;
    private String lastName;

    /**
     * Returns the student ID.
     *
     * @return the student ID
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId the student ID to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns the first name of the student.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the student.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a string representation of the StudentDTO object.
     *
     * @return a string representation of the StudentDTO object
     */
    @Override
    public String toString() {
        return "StudentDTO{" + "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}