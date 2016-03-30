/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;


public class Firm
{
    int ContactNumber;
    String ContactMail;

    public Firm(String ContactNumer, String ContactMail)
    {
        this.ContactNumber = Integer.parseInt(ContactNumer);
        this.ContactMail = ContactMail;
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
