package DataAccess;

import Domain.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDataMapper
{
    public boolean userExists(String name, String pass)
    {
        try
        {
            Connector con = new Connector();
            PreparedStatement prepareStatement = con.getCon().prepareStatement("SELECT * FROM login where `Username` "
                    + "= ? and `Password` = ?;");
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, pass);
            ResultSet res = prepareStatement.executeQuery();
            return res.next();
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<String> viewAuthor(Login login)
    {
        ArrayList<String> author = new ArrayList();
        
        try
        {
            Connector con = new Connector();
            String query = ("SELECT ´Username´, ´FirmID´ from login where ´username´ = '" + login.getUsername() + "');");
            ResultSet res = con.getResults(query);
            
            while(res.next())
            {
                String username = res.getString(1);
                String firmid = res.getString(2);
                author.add(username);
                author.add(firmid);
            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return author;
    }

    public void addLoginToDB(Login login)
    {
        try
        {
            Connector con = new Connector();
            con.getUpdate("INSERT INTO login (`username`, `password`, `firmId`, `authorization`)" + "VALUES ('"
                    + login.getUsername() + "','"
                    + login.getPassword() + "',"
                    + login.getFirmID() + ",'"
                    + login.getAuthorization() + "');");

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public Login getLoginByUsername(String username)
    {
        Login login = null;

        try
        {
            Connector con = new Connector();
            String query = ("SELECT * FROM login where username = '" + username + "'");
            ResultSet res = con.getResults(query);

            while (res.next())
            {
                String password = res.getString("password");
                String firmID = res.getString("firmID");
                String authorization = res.getString("authorization");
                login = new Login(username, password, firmID, authorization);
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return login;
    }

}
