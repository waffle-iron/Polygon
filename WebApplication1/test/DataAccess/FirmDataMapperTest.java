/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Domain.Firm;
import Domain.Login;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruger
 */
public class FirmDataMapperTest
{

    FirmDataMapper firmDM = new FirmDataMapper();

    public FirmDataMapperTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of addFirmToDB method, of class FirmDataMapper.
     */
    @Test
    public void testViewAllFirms()
    {
        ArrayList<Firm> result = firmDM.viewAllFirms();
        assertEquals(3, result.size()); 
    }

}
