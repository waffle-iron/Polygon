package DataAccess;

import Domain.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDataMapper
{

    public boolean userExists(String name, String pass)
    {
        try
        {
            PreparedStatement prepareStatement = Connector.getCon().getconnection().prepareStatement("SELECT * FROM login where `Username` = ? and `Password` = ?;");
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, pass);
            ResultSet res = prepareStatement.executeQuery();
            return res.next();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addLoginToDB(Login login)
    {
        try
        {
            Connector.getCon().getUpdate("INSERT INTO login (`username`, `password`, `firmId`, `authorization`)" + "VALUES ('"
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
            String query = ("SELECT * FROM login where username = '" + username + "'");
            ResultSet res = Connector.getCon().getResults(query);

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
