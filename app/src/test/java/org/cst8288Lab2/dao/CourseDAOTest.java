/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - JUnit Test Class for CourseDAO
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.dto.CourseDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for testing the CRUD operations in the CourseDAO class.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class CourseDAOTest {

    static CourseDAO instance;
    String id;
    String coursename;

    public CourseDAOTest() {
    }

    /**
     * Sets up the database connection before all tests are run.
     */
    @BeforeAll
    public static void setUpClass() {
        instance = new CourseDAO(DBConnection.getConnection());
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
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(id);
        courseDTO.setCourseName(coursename);
        instance.delete(id); // Ensure the test record does not exist
        instance.insert(courseDTO); // Insert the test record
    }

    /**
     * Cleans up the test data after each test is run.
     */
    @AfterEach
    public void tearDown() {
        instance.delete(id); // Delete the test record
    }

    /**
     * Test of retrieve method, of class CourseDAO.
     */
    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        CourseDTO expResult = new CourseDTO();
        expResult.setCourseId(id);
        expResult.setCourseName(coursename);
        CourseDTO result = instance.retrieve(id);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of insert method, of class CourseDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        CourseDTO courseDTO = new CourseDTO();
        String id2 = "tes2222";
        courseDTO.setCourseId(id2);
        courseDTO.setCourseName(coursename);
        instance.delete(id2); // Ensure the test record does not exist
        int expResult = 1;
        int result = instance.insert(courseDTO);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class CourseDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CourseDTO course = new CourseDTO();
        course.setCourseId(id);
        course.setCourseName("new courseName");
        instance.insert(course);
        int expResult = 1;
        int result = instance.update(course);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class CourseDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int expResult = 1;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
}
