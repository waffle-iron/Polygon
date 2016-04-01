package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector
{

    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "polygonDatabase";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    static Statement stmt;
<<<<<<< HEAD
    
=======

>>>>>>> 81d83b178027a70733aaced87afa9bdd5c4c9eec
    public Connector()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
<<<<<<< HEAD
            
=======

>>>>>>> 81d83b178027a70733aaced87afa9bdd5c4c9eec
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public ResultSet getResults(String query)
    {
        ResultSet res;
        try
        {
            res = stmt.executeQuery(query);
            return res;

        } catch (SQLException ex)
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
