/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.dao.CourseDAO;
import org.cst8288Lab2.dao.DBConnection;
import org.cst8288Lab2.dao.StudentCourseDAO;
import org.cst8288Lab2.dao.StudentDAO;
import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;
import org.cst8288Lab2.dto.Term;

/**
 *
 * @author renxihai
 */
public class DataOperator {

    public static CourseDAO courseDAO = new CourseDAO(DBConnection.getConnection());
    public static StudentDAO studentDAO = new StudentDAO(DBConnection.getConnection());
    public static StudentCourseDAO studentCourseDAO = new StudentCourseDAO(DBConnection.getConnection());

    public static StudentDTO assembleStudent(String[] content) {
        StudentDTO sd = new StudentDTO();
        sd.setStudentId(Integer.valueOf(content[0]));
        sd.setFirstName(content[1]);
        sd.setLastName(content[2]);
        return sd;
    }

    public static CourseDTO assembleCourse(String[] content) {
        CourseDTO cd = new CourseDTO();
        cd.setCourseId(content[3]);
        cd.setCourseName(content[4]);
        return cd;
    }

    public static StudentCourseDTO assembleStudentCourse(String[] content) {
        StudentCourseDTO scd = new StudentCourseDTO();
        scd.setCourseId(content[3]);
        scd.setStudentId(Integer.valueOf(content[0]));
        scd.setTerm(Term.getTerm(content[5]));
        scd.setYear(Integer.valueOf(content[6]));
        return scd;
    }

    public static void clearExistsData(StudentDTO sd, CourseDTO cd, StudentCourseDTO scd) {
        studentCourseDAO.delete(scd.getStudentId(), scd.getCourseId());
        studentDAO.delete(sd.getStudentId());
        courseDAO.delete(cd.getCourseId());
    }

    public static void saveNewData(StudentDTO sd, CourseDTO cd, StudentCourseDTO scd) {
        studentDAO.insert(sd);
        courseDAO.insert(cd);
        studentCourseDAO.insert(scd);
    }

}
