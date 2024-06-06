/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.persistence;

import com.algonquin.cst8288.assignment1.employee.ContractEmployee;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.EmployeeService;
import com.algonquin.cst8288.assignment1.employee.EmployeeServiceFactory;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployee;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the {@link PersistenceService} class.
 * <p>
 * This class contains tests for the methods of the {@link PersistenceService}
 * class, ensuring that they function correctly when given various input
 * scenarios.
 * </p>
 *
 * @see PersistenceService
 * @see Formatter
 * @see Employee
 * @see PermanentEmployee
 * @see ContractEmployee
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class PersistenceServiceTest {

    /**
     * The instance of PersistenceService used for testing.
     */
    static PersistenceService instance;
    static EmployeeServiceFactory employeeServiceFactory;

    /**
     * Default constructor for the test class.
     */
    public PersistenceServiceTest() {
    }

    /**
     * Initializes the test class.
     */
    @BeforeClass
    public static void setUpClass() {
        instance = new PersistenceService();
        employeeServiceFactory = new EmployeeServiceFactory();
    }

    /**
     * Cleans up after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        instance = null;
        employeeServiceFactory = null;
    }

    /**
     * Test of saveEmployee method, of class PersistenceService, with null
     * parameters.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSaveEmployeeParametersNull() throws IOException {
        System.out.println("saveEmployee");
        Employee person = null;
        String filename = null;
        Formatter formatter = null;
        instance.saveEmployee(person, filename, formatter);
    }

    /**
     * Test of saveEmployee method, of class PersistenceService, saving a
     * PermanentEmployee in JSON format.
     */
    @Test()
    public void testSavePermanentEmployeeJson() throws IOException {
        System.out.println("Save Permanent Employee to Json");

        PermanentEmployee person = new PermanentEmployee("pTest1", "pTest1@gmail.com", "pTest1 address", 100000, 3);
        EmployeeService service = employeeServiceFactory.createService(person);
        service.populateEmployee(person);

        String filename = "test_json_pEmployee_data.txt";
        Formatter formatter = new JSONFormatter();
        instance.saveEmployee(person, filename, formatter);

        String formatstr = formatter.format(person);
        String filecontent = Files.readString(Paths.get(filename)).trim();
        assertTrue(formatstr.equals(filecontent));
    }

    /**
     * Test of saveEmployee method, of class PersistenceService, saving a
     * PermanentEmployee in text format.
     */
    @Test()
    public void testSavePermanentEmployeeText() throws IOException {
        System.out.println("saveEmployee");

        PermanentEmployee person = new PermanentEmployee("pTest1", "pTest1@gmail.com", "pTest1 address", 100000, 3);
        EmployeeService service = employeeServiceFactory.createService(person);
        service.populateEmployee(person);

        String filename = "test_text_pEmployee_data.txt";
        Formatter formatter = new TextFormatter();
        instance.saveEmployee(person, filename, formatter);

        String formatstr = formatter.format(person);
        String filecontent = Files.readString(Paths.get(filename)).trim();
        assertTrue(formatstr.equals(filecontent));
    }

    /**
     * Test of saveEmployee method, of class PersistenceService, saving a
     * ContractEmployee in JSON format.
     *
     */
    @Test()
    public void testSaveContractEmployeeJson() throws IOException {
        System.out.println("Save Contract Employee to Json");

        ContractEmployee person = new ContractEmployee("cTest1", "cTest1@gmail.com", "cTest1 address", 100000);
        EmployeeService service = employeeServiceFactory.createService(person);
        service.populateEmployee(person);

        String filename = "test_json_cEmployee_data.txt";
        Formatter formatter = new JSONFormatter();
        instance.saveEmployee(person, filename, formatter);

        String formatstr = formatter.format(person);
        String filecontent = Files.readString(Paths.get(filename)).trim();
        assertTrue(formatstr.equals(filecontent));
    }

    /**
     * Test of saveEmployee method, of class PersistenceService, saving a
     * ContractEmployee in text format.
     
     */
    @Test()
    public void testSaveContractEmployeeText() throws IOException {
        System.out.println("saveEmployee");

        ContractEmployee person = new ContractEmployee("cTest1", "cTest1@gmail.com", "cTest1 address", 100000);
        EmployeeService service = employeeServiceFactory.createService(person);
        service.populateEmployee(person);
        String filename = "test_text_cEmployee_data.txt";
        Formatter formatter = new TextFormatter();
        instance.saveEmployee(person, filename, formatter);

        String formatstr = formatter.format(person);
        String filecontent = Files.readString(Paths.get(filename)).trim();
        assertTrue(formatstr.equals(filecontent));
    }

}
