/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Emil
 */
public class CommentDataMapper {
    public static int getNextCommentNr()
    {
        int info = 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT max(CommentID) FROM Comments;");
            res.next();
            info = res.getInt(1);
            con.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return info;
    }
}
