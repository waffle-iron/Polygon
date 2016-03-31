package helperClasses;


public class Firm
{
    int ContactNumber;
    String ContactMail;

    public Firm(String ContactNumer, String ContactMail)
    {
        try
        {
        this.ContactNumber = Integer.parseInt(ContactNumer);
        this.ContactMail = ContactMail;
        } catch(Exception e)
        {
            
        }
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
