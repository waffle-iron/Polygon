package DataAccess;

import Domain.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDataMapper {

    public static int getNextCommentNr() {
        int info = 0;
        try {
            ResultSet res = Connector.getCon().getResults("SELECT max(CommentID) FROM Comments;");
            res.next();
            info = res.getInt(1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return info;
    }

    public static void addCommnetsToDB(ArrayList<Comment> comments, Connection con, int i, int j) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;
        stat = con.prepareStatement("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(?,?,?,?);");
        for (Comment comment : comments) {
            stat.setInt(1, i);
            stat.setInt(2, j);
            stat.setString(3, comment.getType());
            stat.setString(4, comment.getText());
            stat.executeUpdate();
            stat.clearParameters();
            if (comment.getImage() != null && comment.getCommentImage().getBytes() != null) {
                String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?);";
                stat = con.prepareStatement(sql);
                stat.setInt(1, CommentDataMapper.getNextCommentNr());
                stat.setBinaryStream(2, comment.getCommentImage().getBytes(), comment.getCommentImage().getFilepart().getSize());

                stat.executeUpdate();

                stat.clearParameters();
            }
        }
    }

    public static void addCommnetsToDB(ArrayList<Comment> comments, Connection con, int i) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;
        stat = con.prepareStatement("insert into `comments`(`ReportNR`,`CommentType`,`Text`) values(?,?,?,?);");
        for (Comment comment : comments) {

            stat.setInt(1, i);
            stat.setString(2, comment.getType());
            stat.setString(3, comment.getText());
            stat.executeUpdate();
            stat.clearParameters();
            con.commit();
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

    public static void addCommnetsToDB(Comment comment, Connection con, int i, int j) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;

        stat = con.prepareStatement(("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values(?,?,?,?);"));
        stat.setInt(1, i);
        stat.setInt(2, j);
        stat.setString(3, comment.getType());
        stat.setString(4, comment.getText());
        stat.executeUpdate();
        stat.clearParameters();
        con.commit();
        if (comment.getImage() != null && comment.getCommentImage().getBytes() != null) {
            String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?);";
            stat = con.prepareStatement(sql);
            stat.setInt(1, CommentDataMapper.getNextCommentNr());
            stat.setBinaryStream(2, comment.getCommentImage().getBytes(), (int) comment.getCommentImage().getFilepart().getSize());

            stat.executeUpdate();
            stat.clearParameters();
        }
    }

    public static void addCommnetsToDB(Comment comment, Connection con, int i) throws ClassNotFoundException, SQLException {
        PreparedStatement stat;

        stat = con.prepareStatement(("insert into `comments`(`ReportNR`,`CommentType`,`Text`) values(?,?,?);"));
        stat.setInt(1, i);
        stat.setString(2, comment.getType());
        stat.setString(3, comment.getText());
        stat.executeUpdate();
        stat.clearParameters();
        con.commit();
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
       
        ArrayList<Comment> comarr = new ArrayList<>();

        try {
            {
                ResultSet res = Connector.getCon().getResults("SELECT * FROM grp01.comments;");
                res.beforeFirst();
                while (res.next()) {
                    comarr.add(new Comment(res.getString(4), res.getString(5), res.getInt(1), res.getInt(2), res.getInt(3)));
                }
            }
            {
                picturelinkDataMapper.loadImageFromDBToFile(comarr);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return comarr;
    }
}
