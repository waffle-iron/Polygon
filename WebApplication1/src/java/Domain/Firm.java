package Domain;

public class Firm
{
    int firmID;
    int contactNumber;
    String contactMail;

    public Firm(int FirmID, int contactNumber, String contactMail)
    {
        this.firmID = FirmID;
        this.contactNumber = contactNumber;
        this.contactMail = contactMail;
    }
    
    public Firm(String contactNumber, String contactMail)
    {
        this.contactNumber = Integer.parseInt(contactNumber);
        this.contactMail = contactMail;
    }

    public int getFirmID()
    {
        return firmID;
    }

    public void setFirmID(int FirmID)
    {
        this.firmID = FirmID;
    }

    public int getContactNumber()
    {
        return contactNumber;
    }

    public String getContactMail()
    {
        return contactMail;
    }

    public void setContactNumber(int ContactNumber)
    {
        this.contactNumber = ContactNumber;
    }

    public void setContactMail(String ContactMail)
    {
        this.contactMail = ContactMail;
    }

}
