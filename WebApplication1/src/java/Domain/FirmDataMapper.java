package Domain;

import helperClasses.Firm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FirmDataMapper
{
    public void addFirmToDB(Firm firm)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `firm` (`ContactNumber`, `ContactMail`)" + "VALUES(" 
                    + firm.getContactNumber() + ",'" 
                    + firm.getContactMail() + "');");
            con.close();
            } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
