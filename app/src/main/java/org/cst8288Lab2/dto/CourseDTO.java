/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Transfer Object for Course
 */
package org.cst8288Lab2.dto;

/**
 * A Data Transfer Object (DTO) class for representing a course.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author renxihai
 */
public class CourseDTO {
    
    

    private String courseId;
    private String courseName;
    
    

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
     * Returns the course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     *
     * @param courseName the course name to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a string representation of the CourseDTO object.
     *
     * @return a string representation of the CourseDTO object
     */
    @Override
    public String toString() {
        return "CourseDTO{" + "courseId=" + courseId + ", courseName=" + courseName + '}';
    }
}
