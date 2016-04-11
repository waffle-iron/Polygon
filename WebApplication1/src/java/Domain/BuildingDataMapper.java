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
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public String printBuildings()
    {
        ArrayList<Building> listOfBuildings = new ArrayList();
        String resultString = "";

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

            for (Building listOfBuilding : listOfBuildings)
            {
                resultString += listOfBuilding.toString();
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return resultString;
    }

    public ArrayList<Building> getBuildingsFromDatabase()
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

                listOfBuildings.add(new Building(res.getString("Address"),
                        res.getString("Zip"), res.getString("FirmID"),
                        res.getString("Name"), res.getString("BuildingYear"),
                        res.getString("Size"), res.getString("Usage")));
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return listOfBuildings;
    }

    public ArrayList<Building> viewMyBuildings(int firmID)
    {
        ArrayList<Building> buildings = new ArrayList();

        try
        {
            Connector con = new Connector();
            String query = ("SELECT * FROM building WHERE firmID = " + firmID);
            ResultSet res = con.getResults(query);

            while (res.next())
            {
                int buildingID = res.getInt(1);
                String address = res.getString(2);
                int zip = res.getInt(3);
                String name = res.getString(5);
                int buildYear = res.getInt(6);
                int size = res.getInt(7);
                String usage = res.getString(8);
                buildings.add(new Building(address, name, usage, buildingID, zip, firmID, buildYear, size));
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return buildings;
    }
}
