package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector
{

    private static final String HOST = "80.71.140.73";
    private static final int PORT = 3306;
    private static final String DATABASE = "grp01";
    public static final String USERNAME = "grp01";
    public static final String PASSWORD = "7WgF&mjz";
//    static final String HOST = "Localhost";
//    static int PORT = 3306;
//    static String DATABASE = "grp01";
//    final static String USERNAME = "root";
//    final static String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    static Statement stmt;

    public Connector() throws ClassNotFoundException, SQLException
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        stmt = con.createStatement();
    }

    public ResultSet getResults(String query) throws SQLException

    {
        ResultSet res;

        res = stmt.executeQuery(query);
        return res;

    }
}
