/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emil
 */
public class LogicTest {
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of BuildingNameToBuildingID method, of class Logic.
     */
    @Test
    public void testBuildingNameToBuildingID() {
        System.out.println("BuildingNameToBuildingID");
        String str = "";
        int expResult = 0;
        int result = Logic.BuildingNameToBuildingID(str);
        assertEquals(expResult, result);
    }
    
}
