/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - JUnit Test Class for StudentCourseDAO
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.dto.CourseDTO;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.StudentDTO;
import org.cst8288Lab2.dto.Term;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for testing the CRUD operations in the StudentCourseDAO
 * class.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class StudentCourseDAOTest {

    static StudentCourseDAO instance = null;
    Integer studentId = 411274860;
    String firstName = "Xihai";
    String lastName = "Ren";

    String courseId = "mat1234";
    String courseName = "Math";
    Term term = Term.FALL;
    int year = 2024;

    public StudentCourseDAOTest() {
    }

    /**
     * Sets up the database connection before all tests are run.
     */
    @BeforeAll
    public static void setUpClass() {
        instance = new StudentCourseDAO(DBConnection.getConnection());
    }

    /**
     * Tears down the database connection after all tests are completed.
     */
    @AfterAll
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Sets up the test data before each test is run.
     */
    @BeforeEach
    public void setUp() {
        DataOperator dataOperator = new DataOperator();
        String[] content = new String[]{
            studentId.toString(), firstName, lastName, courseId, courseName, term.name(), String.valueOf(year)
        };
        StudentDTO student = dataOperator.assembleStudent(content);
        CourseDTO course = dataOperator.assembleCourse(content);
        StudentCourseDTO studentCourse = dataOperator.assembleStudentCourse(content);
        dataOperator.saveNewData(student, course, studentCourse);
    }

    /**
     * Cleans up the test data after each test is run.
     */
    @AfterEach
    public void tearDown() {
        DataOperator dataOperator = new DataOperator();
        dataOperator.studentCourseDAO.delete(studentId, courseId);
        dataOperator.courseDAO.delete(courseId);
        dataOperator.studentDAO.delete(studentId);
    }

    /**
     * Test of retrieve method, of class StudentCourseDAO.
     */
    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        StudentCourseDTO expResult = new StudentCourseDTO();
        expResult.setCourseId(courseId);
        expResult.setStudentId(studentId);
        expResult.setTerm(term);
        expResult.setYear(year);
        StudentCourseDTO result = instance.retrieve(studentId, courseId);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of insert method, of class StudentCourseDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        DataOperator dataOperator = new DataOperator();
        String[] content = new String[]{
            studentId.toString(), firstName, lastName, courseId, courseName, term.name(), String.valueOf(year)
        };
        StudentCourseDTO studentCourse = dataOperator.assembleStudentCourse(content);
        instance.delete(studentId, courseId);
        int expResult = 1;
        int result = instance.insert(studentCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class StudentCourseDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        DataOperator dataOperator = new DataOperator();
        String[] content = new String[]{
            studentId.toString(), firstName, lastName, courseId, courseName, term.name(), String.valueOf(year)
        };
        StudentCourseDTO studentCourse = dataOperator.assembleStudentCourse(content);
        studentCourse.setTerm(Term.WINTER);
        int expResult = 1;
        int result = instance.update(studentCourse);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class StudentCourseDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int expResult = 1;
        int result = instance.delete(studentId, courseId);
        assertEquals(expResult, result);
    }
}
