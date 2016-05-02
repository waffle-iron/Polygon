package DataAccess;

import Domain.Building;
import Domain.Firm;
import Domain.Login;
import Domain.Report;
import java.awt.Image;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class Facade
{

    private final BuildingDataMapper buildingDM = new BuildingDataMapper();
    private final FirmDataMapper firmDM = new FirmDataMapper();
    private final ReportDataMapper reportDM = new ReportDataMapper();
    private final LoginDataMapper loginDM = new LoginDataMapper();
    private final ImageDataMapper imageDataMapper = new ImageDataMapper();

    public Facade()
    {
        try
        {
            Connector con = Connector.getCon();
        } catch (Exception ex)
        {

        }
    }
    public Building getSingleBuildingByID(int buildingID)
            throws ClassNotFoundException, NumberFormatException, SQLException
    {

        return buildingDM.getSingleBuildingByID(buildingID);
    }

    public void addBuildingToDB(Building build)
            throws ClassNotFoundException, NumberFormatException, SQLException
    {
        buildingDM.addBuildingToDB(build);
    }

    public ArrayList<Building> viewMyBuildings(int firmID)
    {
        return buildingDM.viewMyBuildings(firmID);
    }

    public ArrayList<Integer> getListogReportIDsByBuildingID(int ID) throws SQLException, ClassNotFoundException
    {
        return buildingDM.getListogReportIDsByBuildingID(ID);
    }

    public void removeBuilding(int ID) throws SQLException, ClassNotFoundException
    {
        buildingDM.removeBuilding(ID);
    }

    public ArrayList<Building> getBuildingsFromDatabase()
    {
        return buildingDM.getBuildingsFromDatabase();
    }

    public void addFirmToDB(Firm firm)
    {
        firmDM.addFirmToDB(firm);
    }

    public ArrayList<Firm> viewAllFirms()
    {
        return firmDM.viewAllFirms();
    }

    public void addReportToDB(Report Report)
    {
        reportDM.addReportToDB(Report);
    }

    public Report getReportFromDB(int ReportID)
    {
        return reportDM.getReportFromDB(ReportID);
    }

    public ArrayList<Report> getReportsFromDB()
    {
        return reportDM.getReportsFromDB();
    }

    public int getNumbeOfReportFromDB()
    {
        return reportDM.getNumberOfReportsFromDB();
    }

    public int getNextReportNr()
    {
        return reportDM.getNextReportNr();
    }

    public boolean userExists(String name, String pass)
    {
        return loginDM.userExists(name, pass);
    }
    public void addLoginToDB(Login login)
    {
        loginDM.addLoginToDB(login);
    }

    public Login getLoginByUsername(String username)
    {
        return loginDM.getLoginByUsername(username);
    }

    public static ArrayList<Integer> listOfFirmIDsFromUser(Login username)
    {
        return FirmDataMapper.listOfFirmIDsFromUser(username);
    }
}
