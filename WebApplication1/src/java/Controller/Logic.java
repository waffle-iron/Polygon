package Controller;

import DataAccess.Facade;
import Domain.Building;
import java.util.ArrayList;

public class Logic {
    private static final Facade facade = new Facade();
    public static int BuildingNameToBuildingID(String str){
        int res = 0;
        ArrayList<Building> build =facade.getBuildingsFromDatabase();
        for (Building building : build) {
            if(building.getName() == null ? str == null : building.getName().equals(str))
                res = building.getBuildingID();
             
        }
        return res;
    }
    
}
