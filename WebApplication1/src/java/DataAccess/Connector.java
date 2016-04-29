package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

//    private static final String HOST = "80.71.140.73";
//    private static final int PORT = 3306;
//    private static final String DATABASE = "grp01";
//    public static final String USERNAME = "grp01";
//    public static final String PASSWORD = "7WgF&mjz";
    
    static final String HOST = "Localhost";
    static int PORT = 3306;
    static String DATABASE = "grp01";
    final static String USERNAME = "root";
    final static String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    private static Connector connector;
    private static Connection con;

    private Connector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int getUpdate(String query) throws SQLException {
        int res;
        res = con.createStatement().executeUpdate(query);
        return res;
    }

    public ResultSet getResults(String query) throws SQLException {
        ResultSet res;
        res = con.createStatement().executeQuery(query);
        return res;
    }

    public static Connector getCon() throws ClassNotFoundException, SQLException {
        if (connector == null) {
            connector = new Connector();
            return connector;
        } else {
            return connector;
        }
    }
    public Connection getconnection(){
        return con;
    }

}
