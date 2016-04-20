package DataAccess;

import Domain.Firm;
import Domain.Login;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FirmDataMapper
{

    public void addFirmToDB(Firm firm)
    {
        try
        {
            Connector con = new Connector();
            con.getUpdate("INSERT INTO `firm` (`ContactNumber`, `ContactMail`)" + "VALUES("
                    + firm.getContactNumber() + ",'"
                    + firm.getContactMail() + "');");
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public static ArrayList<Integer> ValidFirmIDsFromUser(Login username)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        try
        {
            Connector con = new Connector();
            ResultSet res = con.getResults("SELECT * FROM firm natural join login where Username = '" + (username.getUsername()) + "'");
            res.beforeFirst();
            for (int i = 0; res.next(); i++)
            {
                temp.add(res.getInt(1));
            }
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

        return temp;
    }

    public ArrayList<Firm> viewAllFirms()
    {
        ArrayList<Firm> firms = new ArrayList();

        try
        {
            Connector con = new Connector();
            String query = ("SELECT * FROM firm");
            ResultSet res = con.getResults(query);
            res.beforeFirst();

            while (res.next())
            {
                int firmID = res.getInt(1);
                int contactNumber = res.getInt(2);
                String contactMail = res.getString(3);
                firms.add(new Firm(firmID, contactNumber, contactMail));
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return firms;
    }
}
