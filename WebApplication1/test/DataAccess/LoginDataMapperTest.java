/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Domain.Login;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruger
 */
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
   }
   
    @Test
    public void testGetLoginByUsername()
    {
        Login result = loginDM.getLoginByUsername("admin");
        assertEquals("admin", result);
    }
}
