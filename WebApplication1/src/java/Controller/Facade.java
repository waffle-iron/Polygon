package Controller;

import Domain.BuildingDataMapper;
import Domain.FirmDataMapper;
import helperClasses.*;

public class Facade
{
    BuildingDataMapper buildingDM = new BuildingDataMapper();
    FirmDataMapper firmDM = new FirmDataMapper();
    
    public void addBuildingToDB(Building build)
    {
        buildingDM.addBuildingToDB(build);
    }
    public void addFirmToDB(Firm firm)
    {
        firmDM.addFirmToDB(firm);
    }
}
