package Controller;

import Domain.*;
import helperClasses.*;

public class Facade
{
    BuildingDataMapper buildingDM = new BuildingDataMapper();
    FirmDataMapper firmDM = new FirmDataMapper();
    ReportDataMapper reportDM = new ReportDataMapper();
    
    public void addBuildingToDB(Building build)
    {
        buildingDM.addBuildingToDB(build);
    }
    public void addFirmToDB(Firm firm)
    {
        firmDM.addFirmToDB(firm);
    }
     public void addReportToDB(Report Report) {
     reportDM.addReportToDB(Report);
     }
     public Report getReportFromDB(int ReportID) {
        return reportDM.getReportFromDB(ReportID);
     }
}
