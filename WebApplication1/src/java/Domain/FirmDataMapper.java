package Domain;

import helperClasses.Firm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FirmDataMapper {

    public void addFirmToDB(Firm firm) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `firm` (`ContactNumber`, `ContactMail`)" + "VALUES("
                    + firm.getContactNumber() + ",'"
                    + firm.getContactMail() + "');");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static ArrayList<Integer> ValidFirmIDsFromUser(String username) {
            ArrayList<Integer> temp = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM grp01.firm natural join login");
            res.beforeFirst();
            for (int i = 0; res.next(); i++) {
                if(res.getString(4).equals(username))
                temp.add(res.getInt(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return temp;
    }
}
