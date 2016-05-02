package DataAccess;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginDataMapperTest
{
    LoginDataMapper loginDM = new LoginDataMapper();
    
    public LoginDataMapperTest()
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
     * Test of userExists method, of class LoginDataMapper.
     */
   @Test
   public void testUserExsists()
   {
       boolean result = loginDM.userExists("admin", "password");
       assertTrue(result);
       
       boolean result1 = loginDM.userExists("admin", "1");
       assertFalse(result1);
       
       boolean result2 = loginDM.userExists("Julemanden", "password");
       assertFalse(result2);
       
       boolean result3 = loginDM.userExists("Stol", "Bord");
       assertFalse(result3);
   }

}
