/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author LouiseB
 */
public class Connector
{
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "polygonDatabase";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    
    Statement stmt;
    
    public Connector()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
