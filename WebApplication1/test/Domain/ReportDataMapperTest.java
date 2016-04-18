/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataAccess.ReportDataMapper;
import java.util.ArrayList;
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
public class ReportDataMapperTest {
    
    public ReportDataMapperTest() {
    }
    static ReportDataMapper instance;
    static ArrayList<Report> reports;
    @BeforeClass
    public static void setUpClass() {
        instance = new ReportDataMapper();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reports = instance.getReportsFromDB();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addReportToDB method, of class ReportDataMapper.
     */
    @Test
    public void testAddReportToDB() {
        System.out.println("addReportToDB");
        Report Report = null;
        ReportDataMapper instance = new ReportDataMapper();
        
    }

    /**
     * Test of getReportFromDB method, of class ReportDataMapper.
     */
    @Test
    public void testGetReportFromDB() {
        System.out.println("getReportFromDB");
        ReportDataMapper instance = new ReportDataMapper();
        Report expResult = null;
        for (int i = 1; i < instance.getNumbeOfReportFromDB()+1; i++) {
        Report result = instance.getReportFromDB(i);
        if(result==null)
            fail("null passed form getReportFromDB on ReportID" + i);
        }
    }

    /**
     * Test of getReportsFromDB method, of class ReportDataMapper.
     */
    @Test
    public void testGetReportsFromDB() {
        System.out.println("getReportsFromDB");
        ReportDataMapper instance = new ReportDataMapper();
        ArrayList<Report> result = instance.getReportsFromDB(); 
        assertNotNull(result);
        assertEquals(3, result.size());
    }
    
}
