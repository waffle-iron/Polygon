package helperClasses;

public class Building
{
    String address;
    String name;
    String usage;
    int buildingID;

    public Building(String address, String name, String usage, int buildingID, int zip, int firmID, int buildYear, int size)
    {
        this.address = address;
        this.name = name;
        this.usage = usage;
        this.buildingID = buildingID;
        this.zip = zip;
        this.firmID = firmID;
        this.buildYear = buildYear;
        this.size = size;
    }
    int zip;
    int firmID;
    int buildYear;
    int size;

    public Building(String address, String zip, String firmID, String name, String buildYear, String size, String usage)
    {
        this.address = address;
        this.name = name;
        this.usage = usage;
        this.zip = Integer.parseInt(zip);
        this.firmID = Integer.parseInt(firmID);
        this.buildYear = Integer.parseInt(buildYear);
        this.size = Integer.parseInt(size);
    }

    @Override
    public String toString()
    {
        return this.address + " " + this.zip + " " + this.firmID + " " 
                + this.name + " " + this.buildYear + " " + this.size + " " + this.usage  + "<br>";
    }
    
    
    public String getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }

    public int getBuildingID()
    {
        return buildingID;
    }

    public int getZip()
    {
        return zip;
    }

    public int getFirmID()
    {
        return firmID;
    }

    public int getBuildYear()
    {
        return buildYear;
    }

    public int getSize()
    {
        return size;
    }
    
    public String getUsage()
    {
        return usage;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBuildingID(int buildingID)
    {
        this.buildingID = buildingID;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public void setFirmID(int firmID)
    {
        this.firmID = firmID;
    }

    public void setBuildYear(int buildYear)
    {
        this.buildYear = buildYear;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
    
    public void setUsage(String usage)
    {
        this.usage = usage;
    }
}
