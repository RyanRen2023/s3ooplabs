/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: George Kriger
 * Due Date: 2024/06/02
 * Description: Assignment 1
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.employee.PermanentEmployeeServiceImpl;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Unit tests for the {@link PermanentEmployeeServiceImpl} class.
 * <p>
 * This class contains tests for the methods of the
 * {@link PermanentEmployeeServiceImpl} class, ensuring that they function
 * correctly when given both valid and null inputs.
 * </p>
 *
 * @see PermanentEmployeeServiceImpl
 * @see PermanentEmployee
 * @see EmployeeServiceFactory
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class PermanentEmployeeServiceImplTest {

    /**
     * Default constructor for the test class.
     */
    public PermanentEmployeeServiceImplTest() {
    }
    /**
     * The employee instance used for testing.
     */
    private PermanentEmployee employee;
    /**
     * The instance of PermanentEmployeeServiceImpl used for testing.
     */
    private static PermanentEmployeeServiceImpl instance;

    /**
     * Initializes the test class.
     */
    @BeforeClass
    public static void setUpClass() {
        instance = new PermanentEmployeeServiceImpl();
    }

    /**
     * Cleans up after all tests have run.
     */
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Sets up the test environment.
     */
    @Before
    public void setUp() {
        employee = new PermanentEmployee("PermanentTest1", "PermanentTest1@gmail.com", "Ottawa,Canada", 100000, 10);

    }

    /**
     * Cleans up the test environment.
     *
     */
    @After
    public void tearDown() {
        employee = null;
    }

    /**
     * Test of calculateTotalCompensation method, of class
     * PermanentEmployeeServiceImpl, when the employee is null.
     */
    @Test
    public void testCalculateTotalCompensationNull() {
        System.out.println("calculateTotalCompensation, employee is null");
        employee = null;
        double expResult = 0.0;
        double result = instance.calculateTotalCompensation(employee);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateTotalCompensation method, of class
     * PermanentEmployeeServiceImpl, when the employee is not null.
     */
    @Test
    public void testCalculateTotalCompensationNotNull() {
        System.out.println("calculateTotalCompensation, employee is not null");
        double expResult = 125000.0;
        double result = instance.calculateTotalCompensation(employee);
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of pensionContribution method, of class
     * PermanentEmployeeServiceImpl, when the employee is null.
     */
    @Test
    public void testPensionContributionNull() {
        System.out.println("pensionContribution, employee is null");
        employee = null;
        double expResult = 0.0;
        double result = instance.pensionContribution(employee);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of pensionContribution method, of class
     * PermanentEmployeeServiceImpl, when the employee is not null.
     */
    @Test
    public void testPensionContributionNotNull() {
        System.out.println("pensionContribution, employee is not null");
        double expResult = 1000.0;
        double result = instance.pensionContribution(employee);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateBonus method, of class PermanentEmployeeServiceImpl,
     * when the employee is null.
     */
    @Test
    public void testCalculateBonusNull() {
        System.out.println("calculateBonus, employee is null");
        employee = null;
        double expResult = 0.0;
        double result = instance.calculateBonus(employee);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateBonus method, of class PermanentEmployeeServiceImpl,
     * when the employee is not null.
     */
    @Test
    public void testCalculateBonusNotNull() {
        System.out.println("calculateBonus, employee is not null");
        double expResult = 25000.0;
        double result = instance.calculateBonus(employee);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of populateEmployee method, of class PermanentEmployeeServiceImpl,
     * when the employee is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPopulateEmployeeNull() {
        System.out.println("populateEmployee, employee is null");
        employee = null;
        instance.populateEmployee(employee);
    }

    /**
     * Test of populateEmployee method, of class PermanentEmployeeServiceImpl,
     * when the employee is not null.
     */
    @Test()
    public void testPopulateEmployeeNotNull() {
        System.out.println("populateEmployee, employee is not null");
        instance.populateEmployee(employee);
        double expectedBonus = 25000.0;
        double expectedTotalCompensation = 125000.0;

        assertEquals(expectedBonus, employee.getBonus(), 0);
        assertEquals(expectedTotalCompensation, employee.getTotalCompensation(), 0);
    }

}
