/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Domain.Comment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Emil
 */
public class picturelinkDataMapper {

    public static BufferedImage loadImageFromDBToFile(ArrayList<Comment> comments) {
        BufferedImage img = null;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM picturelink;");
            res.beforeFirst();
            while (res.next()) {
                int commentID = res.getInt(2);
                Blob blob = res.getBlob(3);
                blobToFileAndBack(blob);
                img = ImageIO.read(new File("C:\\Users\\Emil\\Documents\\NetBeansProjects\\Polygon\\WebApplication1\\images\\1.jpg"));
                for (Comment comment : comments) {

                    if (comment.getCommentID() == commentID && img != null) {
                        comment.setImage(img);
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return img;
    }
    public static void blobToFileAndBack(Blob blob) throws SQLException{
        InputStream inputStream = blob.getBinaryStream();
	OutputStream outputStream = null;

	try {
		// write the inputStream to a FileOutputStream
		outputStream = 
                    new FileOutputStream(new File("C:\\Users\\Emil\\Documents\\NetBeansProjects\\Polygon\\WebApplication1\\images\\1.jpg"));

		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
