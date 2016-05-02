package DataAccess;

import Domain.Firm;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
