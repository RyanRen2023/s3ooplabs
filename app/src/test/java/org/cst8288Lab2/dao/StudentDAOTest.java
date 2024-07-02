/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - JUnit Test Class for StudentDAO
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.dto.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for testing the CRUD operations in the StudentDAO class.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class StudentDAOTest {

    static StudentDAO instance;
    Integer studentId;
    String firstName;
    String lastName;

    public StudentDAOTest() {
    }

    /**
     * Sets up the database connection before all tests are run.
     */
    @BeforeAll
    public static void setUpClass() {
        instance = new StudentDAO(DBConnection.getConnection());
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
        System.out.println("Before Each");
        StudentDTO studentDTO = new StudentDTO();
        studentId = 123456789;
        firstName = "Xihai";
        lastName = "Ren";
        studentDTO.setFirstName(firstName);
        studentDTO.setStudentId(studentId);
        studentDTO.setLastName(lastName);
        instance.delete(studentId); // Ensure the test record does not exist
        instance.insert(studentDTO); // Insert the test record
    }

    /**
     * Cleans up the test data after each test is run.
     */
    @AfterEach
    public void tearDown() {
        studentId = 123456789;
        instance.delete(studentId); // Ensure the test record does not exist
    }

    /**
     * Test of retrieve method, of class StudentDAO.
     */
    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        StudentDTO expResult = new StudentDTO();
        expResult.setFirstName(firstName);
        expResult.setStudentId(studentId);
        expResult.setLastName(lastName);
        StudentDTO result = instance.retrieve(studentId);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of insert method, of class StudentDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        StudentDTO student = new StudentDTO();
        studentId = 888888888;
        student.setFirstName(firstName);
        student.setStudentId(studentId);
        student.setLastName(lastName);
        int expResult = 1;
        instance.delete(studentId); // Ensure the test record does not exist
        int result = instance.insert(student);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class StudentDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        StudentDTO student = new StudentDTO();
        firstName = "Conglin";
        student.setFirstName(firstName);
        student.setStudentId(studentId);
        student.setLastName(lastName);
        int expResult = 1;
        int result = instance.update(student);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class StudentDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int expResult = 1;
        int result = instance.delete(studentId);
        assertEquals(expResult, result);
    }
}
