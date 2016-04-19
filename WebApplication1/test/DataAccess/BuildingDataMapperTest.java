package DataAccess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Domain.Building;
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
public class BuildingDataMapperTest
{

    BuildingDataMapper buildingDM = new BuildingDataMapper();

    public BuildingDataMapperTest()
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
     * Test of printBuildings method, of class BuildingDataMapper.
     */
    @Test
    public void testBuildingsFromDatabase()
    {
        ArrayList<Building> result = buildingDM.getBuildingsFromDatabase();
        assertEquals(3, result.size());
    }

    @Test
    public void testViewMyBuildings()
    {
        ArrayList<Building> result = buildingDM.viewMyBuildings(1);
        assertEquals(2, result.size());
    }
}
