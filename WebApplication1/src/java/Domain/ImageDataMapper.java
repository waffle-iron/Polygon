/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import helperClasses.Date;
import helperClasses.ReportPage;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Emil
 */
public class ImageDataMapper {
    public void addImageToDB(InputStream Report) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO picturelink(IMAGE) VALUES("+Report+")");
                    
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public Image getImageFromDB() {

        Image img = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM picturelink");
            res.beforeFirst();
            for (int i = 0; res.next(); i++) {
                img = res.getObject(2,Image.class);
            }
                    
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return img;
    }
}
