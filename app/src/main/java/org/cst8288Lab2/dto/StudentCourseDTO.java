/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dto;

/**
 *
 * @author renxihai
 */
public class StudentCourseDTO {
    
    private Integer studentId;
    private String courseId;
    private Term term;
    private Integer year;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getTerm() {
        return term.getTermNumber();
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "StudentCourseDTO{" + "studentId=" + studentId + ", courseId=" + courseId + ", term=" + term + ", year=" + year + '}';
    }
    
    
    
}
