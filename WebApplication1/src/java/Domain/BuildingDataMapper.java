package Domain;

import helperClasses.Building;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildingDataMapper
{

    public void addBuildingToDB(Building build)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `building` (`address`, `zip`, `firmID`, `name`, `buildingYear`, `size`, `usage`)" + "VALUES( '"
                    + build.getAddress() + "',"
                    + build.getZip() + ","
                    + build.getFirmID() + ",'"
                    + build.getName() + "',"
                    + build.getBuildYear() + ","
                    + build.getSize() + ",'"
                    + build.getUsage() + "');");
            con.close();
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public String printBuildings(String nope)
    {
        ArrayList<Building> listOfBuildings = new ArrayList();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM building;";
            ResultSet res = stmt.executeQuery(query);

            while (res.next())
            {
                String Address = res.getString("Address");
                String Zip = res.getString("Zip");
                String FirmID = res.getString("FirmID");
                String Name = res.getString("Name");
                String BuildingYear = res.getString("BuildingYear");
                String Size = res.getString("Size");
                String Usage = res.getString("Usage");

                listOfBuildings.add(new Building(Address, Zip, FirmID, Name, BuildingYear, Size, Usage));
                
            }

            con.close();
            
        } catch (Exception ex)
        {

        }
        return listOfBuildings.get(0).toString();
    }
}
