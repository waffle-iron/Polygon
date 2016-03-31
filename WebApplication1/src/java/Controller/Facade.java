package Controller;

import Domain.BuildingDataMapper;
import Domain.FirmDataMapper;

public class Facade
{
    BuildingDataMapper buildingDM = new BuildingDataMapper();
    FirmDataMapper firmDM = new FirmDataMapper();   
}
