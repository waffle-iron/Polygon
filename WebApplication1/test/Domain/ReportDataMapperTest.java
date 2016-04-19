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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Emil
 */
public class ReportDataMapperTest
{
ReportDataMapper reportDM = new ReportDataMapper();

    public ReportDataMapperTest()
    {
    }
//    static ReportDataMapper instance;
//    static ArrayList<Report> reports;

    @BeforeClass
    public static void setUpClass()
    {
       // instance = new ReportDataMapper();
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
       // reports = instance.getReportsFromDB();
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of addReportToDB method, of class ReportDataMapper.
     */
//    @Test
//    public void testAddReportToDB()
//    {
//        System.out.println("addReportToDB");
//        Report Report = null;
//        ReportDataMapper instance = new ReportDataMapper();
//
//    }

    /**
     * Test of getReportFromDB method, of class ReportDataMapper.
     */
//    @Test
//    public void testGetReportFromDB() {
//        System.out.println("getReportFromDB");
//        ReportDataMapper instance = new ReportDataMapper();
//        Report expResult = null;
//        for (int i = 1; i < instance.getNumberOfReportsFromDB()+1; i++) {
//        Report result = instance.getReportFromDB(i);
//        if(result==null)
//            fail("null passed form getReportFromDB on ReportID" + i);
//        }
//    }
    /**
     * Test of getReportsFromDB method, of class ReportDataMapper.
     */
//    @Test
//    public void testGetReportsFromDB() {
//        System.out.println("getReportsFromDB");
//        ReportDataMapper instance = new ReportDataMapper();
//        ArrayList<Report> result = instance.getReportsFromDB(); 
//        assertNotNull(result);
//        assertEquals(3, result.size());
//    }
    @Test
    public void testGetReportFromDB()
    {
        ArrayList<Report> result = reportDM.getReportsFromDB();
        assertEquals(2, result.size());
    }
    
    @Test 
    public void testGetReportFromDM()
    {
        Report result;
        result = reportDM.getReportFromDB(1);
        assertEquals(1, result);
    }
}
