package Domain;

import Enumerators.Authorization;

public class Login
{
    String username;
    String password;
    int firmID;
    String authorization;

    public Login(String username, String password, String firmID, String authorization)
    {
        this.username = username;
        this.password = password;
        this.firmID = Integer.parseInt(firmID);
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

    public String getFirmID()
    {
        return "" + firmID;
    }


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
