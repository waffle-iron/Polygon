/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataAccess.BuildingDataMapper;
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
public class BuildingDataMapperTest {
    
    public BuildingDataMapperTest() {
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
     * Test of printBuildings method, of class BuildingDataMapper.
     */
    @Test
    public void testPrintBuildings() {
        System.out.println("printBuildings");
        BuildingDataMapper instance = new BuildingDataMapper();
        String result = instance.printBuildings();
        assertNotNull(result);
    }
    
}
