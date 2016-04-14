package DataAccess;

import DataAccess.BuildingDataMapper;
import DataAccess.FirmDataMapper;
import DataAccess.ImageDataMapper;
import DataAccess.LoginDataMapper;
import DataAccess.ReportDataMapper;
import Domain.Building;
import Domain.Firm;
import Domain.Login;
import Domain.Report;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;

public class Facade
{

    private final BuildingDataMapper buildingDM = new BuildingDataMapper();
    private final FirmDataMapper firmDM = new FirmDataMapper();
    private final ReportDataMapper reportDM = new ReportDataMapper();
    private final LoginDataMapper loginDM = new LoginDataMapper();
    private final ImageDataMapper imageDataMapper = new ImageDataMapper();

    public void addBuildingToDB(Building build)
    {
        buildingDM.addBuildingToDB(build);
    }
    
    public ArrayList<Building> viewMyBuildings(int firmID)
    {
        return buildingDM.viewMyBuildings(firmID);
    }

    public String printBuildings()
    {
        return buildingDM.printBuildings();
    }

    public ArrayList<Building> getBuildingsFromDatabase()
    {
        return buildingDM.getBuildingsFromDatabase();
    }

    public void addFirmToDB(Firm firm)
    {
        firmDM.addFirmToDB(firm);
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
        return reportDM.getNumbeOfReportFromDB();
    }

    public int getNextReportNr()
    {
        return reportDM.getNextReportNr();
    }

    public void addImageToDB(InputStream Report)
    {
        imageDataMapper.addImageToDB(Report);
    }

    public Image getImageFromDB()
    {
        return imageDataMapper.getImageFromDB();
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
    public static ArrayList<Integer> ValidFirmIDsFromUser(Login username){
        return FirmDataMapper.ValidFirmIDsFromUser(username);
    }
}
