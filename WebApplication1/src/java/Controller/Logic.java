/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import helperClasses.Building;

/**
 *
 * @author Emil
 */
public class Logic {
    private static Facade facade = new Facade();
    public static int BuildingNameToBuildingID(String str){
        int res = 0;
        Building[] build =facade.getBuildingsFromDatabase();
        for (Building building : build) {
            if(building.getName() == null ? str == null : building.getName().equals(str))
                res = building.getBuildingID();
             
        }
        return res;
    }
}
