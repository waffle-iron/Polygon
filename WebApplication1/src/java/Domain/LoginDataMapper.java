package Domain;

import helperClasses.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDataMapper
{

    public boolean userExists(String name, String pass, String firm, String author)
    {
        boolean doExists = false;
        ArrayList<Login> listOfUsers = new ArrayList();

        try
        {
            Connector con = new Connector();
            String query = ("SELECT * FROM login");
            ResultSet res = con.getResults(query);

            while (res.next())
            {
                String username = res.getString("username");
                String password = res.getString("password");
                String firmID = res.getString("firmID");
                String authorization = res.getString("authorization");
                listOfUsers.add(new Login(username, password, firmID, authorization));

            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

        for (Login l : listOfUsers)
        {
            if (l.getUsername().equals(name) && l.getPassword().equals(pass)
                    && l.getFirmID().equals(firm) && l.getAuthorization().equals(author))
            {
                doExists = true;
            }
        }
        return doExists;
    }

    public void addLoginToDB(Login login)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO login (`username`, `password`, `firmId`, `authorization`)" + "VALUES ('"
                    + login.getUsername() + "','"
                    + login.getPassword() + "',"
                    + login.getFirmID() + ",'"
                    + login.getAuthorization() + "');");

        } catch (Exception ex)
        {
            System.out.println(ex.toString());

        }
    }
}
