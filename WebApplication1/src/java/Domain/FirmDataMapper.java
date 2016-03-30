/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import helperClasses.Firm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author LouiseB
 */
public class FirmDataMapper
{
    public void addFirmDoDB(Firm firm)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `firm` (`ContactNumber`, `ContactMail`)" + "VALUES(" 
                    + firm.getContactNumber() + ",'" + firm.getContactMail() + "');");
            con.close();
            } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
