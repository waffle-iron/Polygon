/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import helperClasses.Building;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Bruger
 */
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
}
