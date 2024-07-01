/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.cst8288Lab2.dao;

import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author renxihai
 */
public class PropertiesToolTest {
    
    public PropertiesToolTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getProperties method, of class PropertiesTool.
     */
    @Test
    public void testGetProperties() {
        System.out.println("getProperties");
        Properties prop = PropertiesTool.getProperties();
        assertNotNull(prop);
        assertEquals("mysql",prop.getProperty("db"));
    }

    /**
     * Test of reset method, of class PropertiesTool.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Properties prop1 = PropertiesTool.getProperties();
        PropertiesTool.reset();
        Properties prop2 = PropertiesTool.getProperties();
        assertNotSame(prop2, prop1);
    }
    
}
