package DataAccess;

import Domain.Building;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildingDataMapper
{

    public Building getSingleBuildingByID(int buildingID) throws
            ClassNotFoundException, SQLException, NumberFormatException
    {
        Building building = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM building where BuildingID = " + buildingID + ";";
        ResultSet res = stmt.executeQuery(query);

        while (res.next())
        {

            building
                    = new Building(res.getString("Address"), res.getString("Name"),
                            res.getString("Usage"), Integer.parseInt(res.getString("BuildingID")),
                            Integer.parseInt(res.getString("Zip")), Integer.parseInt(res.getString("FirmID")),
                            Integer.parseInt(res.getString("BuildingYear")),
                            Integer.parseInt(res.getString("Size")));
        }

        return building;
    }

    public void addBuildingToDB(Building build)
            throws ClassNotFoundException, SQLException
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

    }

    public ArrayList<Building> getBuildingsFromDatabase()
    {
        ArrayList<Building> listOfBuildings = new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement stmt = con.createStatement();
            String query = "SELECT b.BuildingID, Address, zip, firmID,`name`,buildingyear,size,`usage`, \n"
                    + "(SELECT StateNR FROM report WHERE `date`=(\n"
                    + "	SELECT max(`date`) FROM report where BuildingID = b.BuildingID) and BuildingID = b.BuildingID) as StateNR \n"
                    + "    from building b order by StateNR desc;";
            ResultSet res = stmt.executeQuery(query);

            while (res.next())
            {

                listOfBuildings.add(
                        new Building(res.getString("Address"), res.getString("Name"),
                                res.getString("Usage"), Integer.parseInt(res.getString("BuildingID")),
                                Integer.parseInt(res.getString("Zip")), Integer.parseInt(res.getString("FirmID")),
                                Integer.parseInt(res.getString("BuildingYear")),
                                Integer.parseInt(res.getString("Size"))));
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
            String query = ("SELECT b.BuildingID, Address, zip, firmID,`name`,buildingyear,size,`usage`, \n"
                    + "(SELECT StateNR FROM report WHERE `date`=(\n"
                    + "	SELECT max(`date`) FROM report where BuildingID = b.BuildingID) and BuildingID = b.BuildingID) as StateNR \n"
                    + " from building b WHERE firmID = " + firmID + " order by StateNR desc;");
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

    public void removeBuilding(int buildingID)
    {

    }
}
