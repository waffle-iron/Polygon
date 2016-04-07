package Controller;

import Domain.BuildingDataMapper;
import Domain.FirmDataMapper;
import Domain.ImageDataMapper;
import Domain.LoginDataMapper;
import Domain.ReportDataMapper;
import helperClasses.Building;
import helperClasses.Firm;
import helperClasses.Login;
import helperClasses.Report;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;

public class Facade
{

    private BuildingDataMapper buildingDM = new BuildingDataMapper();
    private FirmDataMapper firmDM = new FirmDataMapper();
    private ReportDataMapper reportDM = new ReportDataMapper();
    private LoginDataMapper loginDM = new LoginDataMapper();
    private ImageDataMapper imageDataMapper = new ImageDataMapper();

    public void addBuildingToDB(Building build)
    {
        buildingDM.addBuildingToDB(build);
    }

    public String printBuildings()
    {
        return buildingDM.printBuildings();
    }

    public  ArrayList<Building> getBuildingsFromDatabase()
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

    public boolean userExists(String name, String pass, String firm, String author)
    {
        System.out.println("test4");
        return loginDM.userExists(name, pass, firm, author);
    }
    
    public void addLoginToDB(Login login)
    {
        loginDM.addLoginToDB(login);
    }
}
