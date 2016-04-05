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
    // Authorization authorization;
    String authorization;

    public Login(String username, String password, String firmID, String authorization)
    {
        this.username = username;
        this.password = password;
        this.firmID = Integer.parseInt(firmID);
        this.authorization = authorization;
//        switch (authorization)
//        {
//            case "tech":
//                this.authorization = Authorization.tech;
//                break;
//
//            case "admin":
//                this.authorization = Authorization.admin;
//                break;
//
//            case "user":
//                this.authorization = Authorization.user;
//                break;
//                default:
//                this.authorization=Authorization.user;
//        }
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFirmID()
    {
        return "" + firmID;
    }

//    public Authorization getAuthorization()
//    {
//        return authorization;
//    }
//    public void setAuthorization(Authorization authorization)
//    {
//        this.authorization = authorization;
//    }
    public String getAuthorization()
    {
        return authorization;
    }

    public Authorization getAuthorizationAsEnum()
    {
        switch (authorization)
        {
            case "tech":
                return Authorization.tech;
                

            case "admin":
                return Authorization.admin;
                

            case "user":
                return Authorization.user;
                
            default:
                return Authorization.user;
        }
       
    }

    public void setAuthorization(String authorization)
    {
        this.authorization = authorization;
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
}
