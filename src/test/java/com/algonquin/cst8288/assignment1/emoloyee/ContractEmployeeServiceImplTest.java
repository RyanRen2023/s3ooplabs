/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.employee.ContractEmployee;
import com.algonquin.cst8288.assignment1.employee.ContractEmployeeServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the {@link ContractEmployeeServiceImpl} class.
 * <p>
 * This class contains tests for the methods of the
 * {@link ContractEmployeeServiceImpl} class, ensuring that they function
 * correctly when given both valid and null inputs.
 * </p>
 *
 * @see ContractEmployeeServiceImpl
 * @see ContractEmployee
 * @see EmployeeServiceFactory
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class ContractEmployeeServiceImplTest {

    /**
     * Default constructor for the test class.
     */
    public ContractEmployeeServiceImplTest() {
    }
    /**
     * The employee instance used for testing.
     */
    private ContractEmployee employee;
    /**
     * The instance of ContractEmployeeServiceImpl used for testing.
     */
    private static ContractEmployeeServiceImpl instance;
    /**
     * The expected renewal date result for the tests.
     */
    private String expResult;

    /**
     * Initializes the test class.
     *
     */
    @BeforeClass
    public static void setUpClass() {
        instance = new ContractEmployeeServiceImpl();
    }

    /**
     * Cleans up after all tests have run.
     *
     */
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Sets up the test environment.
     *
     */
    @Before
    public void setUp() {
        employee = new ContractEmployee("ContractTest1", "ContractTest1@gmail.com", "Ottawa,Canada", 120000);  
        Calendar c= Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        expResult = sdf.format(c.getTime());
    }

    /**
     * Cleans up the test environment.
     *
     */
    @After
    public void tearDown() {
        employee = null;
        expResult = null;
    }

    /**
     * Test of renewalDate method, of class ContractEmployeeServiceImpl.
     */
    @Test
    public void testRenewalDate() {
        System.out.println("renewalDate");
        Date result = instance.renewalDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(expResult, sdf.format(result));

    }

    /**
     * Test of populateEmployee method, of class ContractEmployeeServiceImpl.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPopulateEmployeeNull() {
        System.out.println("populateEmployee, employee is null");
        employee = null;
        instance.populateEmployee(employee);
    }

    /**
     * Test of populateEmployee method, of class ContractEmployeeServiceImpl.
     */
    @Test()
    public void testPopulateEmployeeNotNull() {
        System.out.println("populateEmployee, employee is not null");
        instance.populateEmployee(employee);
        Date result = employee.getRenewalDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(expResult, sdf.format(result));
    }

}
