/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import Enumerators.Authorization;

/**
 *
 * @author Bruger
 */
public class Login
{
    String username;
    String password;
    int firmID;
    Authorization authorization; 

    public Login(String username, String password, int firmID, Authorization authorization)
    {
        this.username = username;
        this.password = password;
        this.firmID = firmID;
        this.authorization = authorization;
    }
    
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getFirmID()
    {
        return firmID;
    }

    public Authorization getAuthorization()
    {
        return authorization;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setFirmID(int firmID)
    {
        this.firmID = firmID;
    }

    public void setAuthorization(Authorization authorization)
    {
        this.authorization = authorization;
    }
    
    
}
