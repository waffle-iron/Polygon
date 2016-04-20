/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Domain.Comment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Emil
 */
public class CommentDataMapper {

    public static int getNextCommentNr() {
        int info = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT max(CommentID) FROM Comments;");
            res.next();
            info = res.getInt(1);
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return info;
    }

    public static void addCommnetsToDB(ArrayList<Comment> comments, Connection con) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;
        stat = con.prepareStatement("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(?,?,?,?);");
        for (Comment comment : comments) {

            
            stat.setInt(1, ReportDataMapper.getNextReportNr() - 1);
            stat.setInt(2, ReportDataMapper.getNextReportPageNr() - 1);
            stat.setString(3, comment.getType());
            stat.setString(4, comment.getText());
            stat.executeUpdate();
            stat.clearParameters();
            if (comment.getImage() != null && comment.getCommentImage().getBytes() != null) {
                String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?);";
                stat = con.prepareStatement(sql);
                stat.setInt(1, CommentDataMapper.getNextCommentNr());
                stat.setBinaryStream(2, comment.getCommentImage().getBytes(), (int) comment.getCommentImage().getFilepart().getSize());

                stat.executeUpdate();
                stat.clearParameters();
            }
        }
    }

    public static void addCommnetsToDB(Comment comment, Connection con) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;

        stat = con.prepareStatement(("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(?,?,?,?);"));
        stat.setInt(1, ReportDataMapper.getNextReportNr() - 1);
        stat.setInt(2, ReportDataMapper.getNextReportPageNr() - 1);
        stat.setString(3, comment.getType());
        stat.setString(4, comment.getText());
        stat.executeUpdate();
        stat.clearParameters();
        if (comment.getImage() != null && comment.getCommentImage().getBytes() != null) {
            String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?);";
            stat = con.prepareStatement(sql);
            stat.setInt(1, CommentDataMapper.getNextCommentNr());
            stat.setBinaryStream(2, comment.getCommentImage().getBytes(), (int) comment.getCommentImage().getFilepart().getSize());

            stat.executeUpdate();
            stat.clearParameters();
        }
    }

    public static ArrayList<Comment> getCommentsFromDB() {
        Connection con = null;
        ArrayList<Comment> comarr = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            {
                ResultSet res = statement.executeQuery("SELECT * FROM grp01.comments;");
                res.beforeFirst();
                while (res.next()) {
                    comarr.add(new Comment(res.getString(4), res.getString(5), res.getInt(1), res.getInt(2), res.getInt(3)));
                }
            }
            /*{
                ResultSet res = statement.executeQuery("SELECT * FROM picturelink;");
                res.beforeFirst();
                while (res.next()) {
                    int commentID = res.getInt(2);
                    Blob blob = res.getBlob(3);
                    int blobLength = (int) blob.length();
                    byte[] blobAsBytes = blob.getBytes(1, blobLength);
                    blob.free();
                    ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(blobAsBytes));
                    BufferedImage img = ImageIO.read(iis);
                    for (Comment comment : comarr) {

                        if (comment.getCommentID() == commentID && img != null) {
                            comment.setImage(img);
                        }
                    }
                }
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comarr;
    }
}
