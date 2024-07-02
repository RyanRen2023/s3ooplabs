/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Transfer Object for StudentCourse
 */
package org.cst8288Lab2.dto;

/**
 * A Data Transfer Object (DTO) class for representing the relationship between
 * a student and a course.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class StudentCourseDTO {

    private Integer studentId;
    private String courseId;
    private Term term;
    private Integer year;

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
     * Returns the course ID.
     *
     * @return the course ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the course ID.
     *
     * @param courseId the course ID to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Returns the term number.
     *
     * @return the term number
     */
    public Integer getTerm() {
        return term.getTermNumber();
    }

    /**
     * Sets the term.
     *
     * @param term the term to set
     */
    public void setTerm(Term term) {
        this.term = term;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year.
     *
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Returns a string representation of the StudentCourseDTO object.
     *
     * @return a string representation of the StudentCourseDTO object
     */
    @Override
    public String toString() {
        return "StudentCourseDTO{" + "studentId=" + studentId + ", courseId=" + courseId + ", term=" + term + ", year=" + year + '}';
    }
}
