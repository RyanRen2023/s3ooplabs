/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Operator for Assembling and Managing Data
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;
import org.cst8288Lab2.dto.Term;

/**
 * A class for assembling DTO objects from raw data and performing operations on
 * data such as inserting new data and clearing existing data from the database.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class DataOperator {

    /**
     * The CourseDAO instance for performing operations related to courses.
     */
    public CourseDAO courseDAO = new CourseDAO(DBConnection.getConnection());

    /**
     * The StudentDAO instance for performing operations related to students.
     */
    public StudentDAO studentDAO = new StudentDAO(DBConnection.getConnection());

    /**
     * The StudentCourseDAO instance for performing operations related to
     * student courses.
     */
    public StudentCourseDAO studentCourseDAO = new StudentCourseDAO(DBConnection.getConnection());

    /**
     * Assembles a StudentDTO object from the provided content array.
     *
     * @param content an array of strings containing student data
     * @return the assembled StudentDTO object
     */
    public StudentDTO assembleStudent(String[] content) {
        StudentDTO sd = new StudentDTO();
        sd.setStudentId(Integer.valueOf(content[0]));
        sd.setFirstName(content[1]);
        sd.setLastName(content[2]);
        return sd;
    }

    /**
     * Assembles a CourseDTO object from the provided content array.
     *
     * @param content an array of strings containing course data
     * @return the assembled CourseDTO object
     */
    public CourseDTO assembleCourse(String[] content) {
        CourseDTO cd = new CourseDTO();
        cd.setCourseId(content[3]);
        cd.setCourseName(content[4]);
        return cd;
    }

    /**
     * Assembles a StudentCourseDTO object from the provided content array.
     *
     * @param content an array of strings containing student course data
     * @return the assembled StudentCourseDTO object
     */
    public StudentCourseDTO assembleStudentCourse(String[] content) {
        StudentCourseDTO scd = new StudentCourseDTO();
        scd.setCourseId(content[3]);
        scd.setStudentId(Integer.valueOf(content[0]));
        scd.setTerm(Term.getTerm(content[5]));
        scd.setYear(Integer.valueOf(content[6]));
        return scd;
    }

    /**
     * Clears existing data from the database for the specified student, course,
     * and student-course relationship.
     *
     * @param sd the StudentDTO object representing the student
     * @param cd the CourseDTO object representing the course
     * @param scd the StudentCourseDTO object representing the student-course
     * relationship
     */
    public void clearExistsData(StudentDTO sd, CourseDTO cd, StudentCourseDTO scd) {
        studentCourseDAO.delete(scd.getStudentId(), scd.getCourseId());
        studentDAO.delete(sd.getStudentId());
        courseDAO.delete(cd.getCourseId());
    }

    /**
     * Saves new data to the database for the specified student, course, and
     * student-course relationship.
     *
     * @param sd the StudentDTO object representing the student
     * @param cd the CourseDTO object representing the course
     * @param scd the StudentCourseDTO object representing the student-course
     * relationship
     */
    public void saveNewData(StudentDTO sd, CourseDTO cd, StudentCourseDTO scd) {
        StudentDTO sd2 = studentDAO.retrieve(sd.getStudentId());
        if (sd2 != null) {
            studentDAO.update(sd);
        } else {
            studentDAO.insert(sd);
        }
        CourseDTO cd2 = courseDAO.retrieve(cd.getCourseId());
        if (cd2 != null) {
            courseDAO.update(cd);

        } else {
            courseDAO.insert(cd);

        }
        StudentCourseDTO scd2 = studentCourseDAO.retrieve(scd.getStudentId(), scd.getCourseId());
        if (scd2 != null) {
            studentCourseDAO.update(scd);
        } else {
            studentCourseDAO.insert(scd);

        }
    }
}
