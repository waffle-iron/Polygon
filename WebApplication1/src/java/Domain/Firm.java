package Domain;

public class Firm
{
    int FirmID;
    int ContactNumber;
    String ContactMail;

    public Firm(int FirmID, int contactNumber, String contactMail)
    {
        this.FirmID = FirmID;
        this.ContactNumber = contactNumber;
        this.ContactMail = contactMail;
    }
    
    public Firm(String contactNumber, String contactMail)
    {
        this.ContactNumber = Integer.parseInt(contactNumber);
        this.ContactMail = contactMail;
    }

    public int getFirmID()
    {
        return FirmID;
    }

    public void setFirmID(int FirmID)
    {
        this.FirmID = FirmID;
    }

    public int getContactNumber()
    {
        return ContactNumber;
    }

    public String getContactMail()
    {
        return ContactMail;
    }

    public void setContactNumber(int ContactNumber)
    {
        this.ContactNumber = ContactNumber;
    }

    public void setContactMail(String ContactMail)
    {
        this.ContactMail = ContactMail;
    }

}
