package DataAccess;

import Domain.Building;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuildingDataMapper
{

    public ArrayList<Integer> getListogReportIDsByBuildingID(int ID) throws SQLException, ClassNotFoundException
    {
        ArrayList<Integer> result = new ArrayList<>();

        String query = "select ReportNR from report where BuildingID = " + ID + ";";
        ResultSet res = Connector.getResults(query);

        while (res.next())
        {
            result.add(res.getInt(1));
        }
        return result;
    }

    public Building getSingleBuildingByID(int buildingID) throws
            ClassNotFoundException, SQLException, NumberFormatException
    {
        Building building = null;

        String query = "SELECT * FROM building where BuildingID = " + buildingID + ";";
        ResultSet res = Connector.getResults(query);

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

        Connector.getUpdate("INSERT INTO `building` (`address`, `zip`, `firmID`, `name`, `buildingYear`, `size`, `usage`)" + "VALUES( '"
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
            String query = "SELECT b.BuildingID, Address, zip, firmID,`name`,buildingyear,size,`usage`, \n"
                    + "(SELECT StateNR FROM report WHERE `date`=(\n"
                    + "	SELECT max(`date`) FROM report where BuildingID = b.BuildingID limit 1) and BuildingID = b.BuildingID limit 1) as StateNR \n"
                    + "    from building b order by StateNR desc;";
            ResultSet res = Connector.getResults(query);
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
            ex.printStackTrace();
        }
        return listOfBuildings;
    }

    public ArrayList<Building> viewMyBuildings(int firmID)
    {
        ArrayList<Building> buildings = new ArrayList();

        try
        {
            String query = ("SELECT b.BuildingID, Address, zip, firmID,`name`,buildingyear,size,`usage`, \n"
                    + "(SELECT StateNR FROM report WHERE `date`=(\n"
                    + "	SELECT max(`date`) FROM report where BuildingID = b.BuildingID limit 1) and BuildingID = b.BuildingID limit 1) as StateNR \n"
                    + " from building b WHERE firmID = " + firmID + " order by StateNR desc;");
            ResultSet res = Connector.getResults(query);

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
            ex.printStackTrace();
        }
        return buildings;
    }

    public void removeBuilding(int ID) throws SQLException, ClassNotFoundException
    {
        String query = "DELETE FROM building WHERE BuildingID = " + ID + ";";
        Connector.getUpdate(query);
    }
}
