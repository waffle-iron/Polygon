/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import Domain.ReportDataMapper;
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
public class ReportTest {
    
    public ReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    ReportDataMapper instance;
    @Before
    public void setUp() {
         instance = new ReportDataMapper();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Report.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = this.instance.getReportFromDB(2);
        Report instance = this.instance.getReportFromDB(1);
        boolean result = instance.equals(obj);
        assertFalse(result);
    }
}
