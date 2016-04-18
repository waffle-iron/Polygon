/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Domain.Comment;
import Domain.Date;
import Domain.Report;
import Domain.ReportPage;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ReportDataMapper {

    public void addReportToDB(Report Report) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into `report` (`BuildingID`,`Date`,`StateNR`)  values('"
                    + Report.getBuildingID() + "','"
                    + Report.getReportDate().toSQLString() + "','"
                    + +Report.getState() + "');");
            for (ReportPage reportpage : Report.getReportPages()) {

                statement.executeUpdate("insert into `reportpage`(`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`) values('"
                        + (getNextReportNr() - 1) + "','"
                        + reportpage.getPreviousDamaged() + "','"
                        + reportpage.getDamagedDate().toSQLString() + "','"
                        + reportpage.getDamagedPlace() + "','"
                        + reportpage.getCause() + "','"
                        + reportpage.getRepairs() + "','"
                        + reportpage.getMoist() + "','"
                        + reportpage.getRot() + "','"
                        + reportpage.getMold() + "','"
                        + reportpage.getFire() + "','"
                        + reportpage.getOther() + "','"
                        + reportpage.getMoistScan() + "');");
                for (Comment comment : reportpage.getComments()) {
                    statement.executeUpdate("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values('"
                            + (getNextReportNr() - 1) + "','"
                            + (getNextReportPageNr() - 1) + "','"
                            + comment.getType() + "','"
                            + comment.getText() + "');");
                    if (comment.getImage() != null) {
                        String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?)";
                        PreparedStatement stat = con.prepareStatement(sql);
                        stat.setInt(1, CommentDataMapper.getNextCommentNr());
             
                        if (comment.getCommentImage().getBytes() != null) 
                        {
                            stat.setBinaryStream(2, comment.getCommentImage().getBytes(), (int) comment.getCommentImage().getFilepart().getSize());
                        }
                        stat.executeUpdate();
                    }
                }
            }
            if (Report.getOuterWalls() != null) {
                statement.executeUpdate("insert into `comments`(`ReportNR`,`CommentType`,`Text`) values('"
                        + (getNextReportNr() - 1) + "','"
                        + Report.getOuterWalls().getType() + "','"
                        + Report.getOuterWalls().getText() + "');");
                if (Report.getOuterWalls().getImage() != null) {
                    String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?)";
                        PreparedStatement stat = con.prepareStatement(sql);
                        stat.setInt(1, CommentDataMapper.getNextCommentNr());
             
                        if (Report.getOuterWalls().getCommentImage().getBytes() != null) 
                        {
                            stat.setBinaryStream(2, Report.getOuterWalls().getCommentImage().getBytes(), (int) Report.getOuterWalls().getCommentImage().getFilepart().getSize());
                        }
                        stat.executeUpdate();
                }
            }
            if (Report.getRoof() != null) {
                statement.executeUpdate("insert into `comments`(`ReportNR`,`CommentType`,`Text`) values('"
                        + (getNextReportNr() - 1) + "','"
                        + Report.getRoof().getType() + "','"
                        + Report.getRoof().getText() + "');");
                if (Report.getRoof().getImage() != null) {
                    String sql = "INSERT INTO picturelink (CommentID, Picture) values (?, ?)";
                        PreparedStatement stat = con.prepareStatement(sql);
                        stat.setInt(1, CommentDataMapper.getNextCommentNr());
             
                        if (Report.getRoof().getCommentImage().getBytes() != null) 
                        {
                            stat.setBinaryStream(2, Report.getRoof().getCommentImage().getBytes(), (int) Report.getRoof().getCommentImage().getFilepart().getSize());
                        }
                        stat.executeUpdate();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }
    }

    public Report getReportFromDB(int ReportID) {
        Report report = null;

        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        ArrayList<Comment> comarr = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            {
                ResultSet res = statement.executeQuery("SELECT * FROM grp01.comments;");
                res.beforeFirst();
                while (res.next()) {
                    System.out.println("found a comment");
                    comarr.add(new Comment(res.getString(4), res.getString(5), res.getInt(1), res.getInt(2), res.getInt(3)));
                }
            }
            {
                ResultSet res = statement.executeQuery("SELECT * FROM grp01.picturelink;");
                res.beforeFirst();
                while (res.next()) {
                    int commentID = res.getInt(2);
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(res.getBytes(3)));
                    System.out.println("found a image");
                    for (Comment comment : comarr) {
                        
                        if (comment.getCommentID() == commentID && img != null) {
                            System.out.println("added a image to comment");
                            comment.setImage(img);
                        }
                    }
                }
            }
            ResultSet res = statement.executeQuery("select  ReportPageNr ,reportNR, "
                    + "(select BuildingID from report where report.reportNR  = e.reportNR),"
                    + "(select `Date` from report where report.reportNR  = e.reportNR),"
                    + "(select StateNR from report where report.reportNR  = "
                    + "e.reportNR), PreviousDamaged, Damagedate,DamagedPlace,Cause,Repairs,"
                    + "Moist,Rot,Mold,fire,other,MoistScan from reportpage e;");
            res.beforeFirst();
            for (int i = 0; res.next(); i++) {
                if (res.getInt(2) == ReportID) {
                    info[0] = res.getInt(2);
                    info[1] = res.getInt(3);
                    info[2] = res.getInt(5);
                    arr.add(new ReportPage(res.getInt(2), res.getInt(1), res.getBoolean(6), new Date(res.getDate(7)), res.getString(8), res.getString(9), res.getString(10), res.getBoolean(11), res.getBoolean(12), res.getBoolean(13), res.getBoolean(14), res.getString(15), res.getBoolean(16), new ArrayList<Comment>()));
                }
            }
            for (ReportPage reportpage : arr) {
                for (Comment comment : comarr) {
                    
                    if (reportpage.getReportPageNr() == comment.getReportPageID()) {
                        System.out.println(reportpage.getReportPageNr());
                        System.out.println("added comment to reportpage");
                        reportpage.addComment(comment);
                    }
                }
            }
            res.beforeFirst();
            ReportPage list2[] = new ReportPage[arr.size()];
            for (int i = 0; res.next(); i++) {
                if (res.getInt(2) == ReportID) {
                    report = new Report(res.getInt(2), res.getInt(3), new Date(res.getDate(4)), res.getInt(5), (ReportPage[]) arr.toArray(list2), null, null);
                }
            }

            for (Comment comment : comarr) {
                
                if (comment.getReportID() == ReportID && comment.getReportPageID() == 0 && comment.getType().equals("Ceiling")) {
                    System.out.println("added comment to report walls");
                    report.setOuterWalls(comment);
                } else if (comment.getReportID() == ReportID && comment.getReportPageID() == 0 && comment.getType().equals("outerWall")) {
                    System.out.println("added comment to report roof");
                    report.setRoof(comment);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return report;
    }

    public ArrayList<Report> getReportsFromDB() {
        ArrayList<Report> report = new ArrayList<>();

        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        ArrayList<Comment> comarr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            {
                ResultSet res = statement.executeQuery("SELECT * FROM grp01.comments;");
                res.beforeFirst();
                while (res.next()) {
                    System.out.println("found a comment");
                    comarr.add(new Comment(res.getString(4), res.getString(5), res.getInt(1), res.getInt(2), res.getInt(3)));
                }
            }
            {
                ResultSet res = statement.executeQuery("SELECT * FROM grp01.picturelink;");
                res.beforeFirst();
                while (res.next()) {
                    int commentID = res.getInt(2);
                    if(res.getBlob(3)!=null){
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(res.getBytes(3)));
                        System.out.println("found a image");

                    for (Comment comment : comarr) {
                        if (comment.getCommentID() == commentID) {
                            comment.setImage(img);
                        }
                    }
                    }
                }
            }
            ResultSet res = statement.executeQuery("select  ReportPageNr ,reportNR, ("
                    + "select BuildingID from report where report.reportNR  = e.reportNR),"
                    + "(select `Date` from report where report.reportNR  = e.reportNR),"
                    + "(select StateNR from report where report.reportNR  = e.reportNR), "
                    + "PreviousDamaged, Damagedate,DamagedPlace,Cause,Repairs,Moist,Rot,"
                    + "Mold,fire,other,MoistScan from reportpage e;");
            res.beforeFirst();
            for (int i = 0; res.next(); i++) {
                info[0] = res.getInt(2);
                info[1] = res.getInt(3);
                info[2] = res.getInt(5);
                arr.add(new ReportPage(res.getInt(2), res.getInt(1), res.getBoolean(6), new Date(res.getDate(7)), res.getString(8), res.getString(9), res.getString(10), res.getBoolean(11), res.getBoolean(12), res.getBoolean(13), res.getBoolean(14), res.getString(15), res.getBoolean(16), null));
                Report reportholder = new Report(res.getInt(2), res.getInt(3), new Date(res.getDate(4)), res.getInt(5), null, null, null);
                if (!reportholder.equals(report.get(report.size()))) {
                    report.add(reportholder);
                }
            }
            for (ReportPage reportpage : arr) {
                for (Comment comment : comarr) {
                    if (reportpage.getReportPageNr() == comment.getReportPageID()) {
                        System.out.println("added comment to reportpage");
                        reportpage.addComment(comment);
                    }
                }
            }
            for (Report singlereport : report) {
                ArrayList<ReportPage> reportpageholder = new ArrayList<>();
                for (ReportPage reportPage : arr) {
                    if (reportPage.getReportNr() == singlereport.getReportnr()) {
                        reportpageholder.add(reportPage);
                        System.out.println("added reportpage to report");
                    }
                }
                ReportPage[] reportpage = new ReportPage[reportpageholder.size()];
                singlereport.setReportPages((ReportPage[]) reportpageholder.toArray(reportpage));
            }
            for (Report singlereport : report) {

                for (Comment comment : comarr) {
                    System.out.println("added comment to report");
                    if (comment.getReportID() == singlereport.getReportnr() && comment.getReportPageID() == 0 && comment.getType().equals("Ceiling")) {
                        singlereport.setOuterWalls(comment);
                    } else if (comment.getReportID() == singlereport.getReportnr() && comment.getReportPageID() == 0 && comment.getType().equals("outerWall")) {
                        singlereport.setRoof(comment);
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("testing");
        return report;
    }

    public int getNumbeOfReportFromDB() {

        int info = 0;
        ArrayList<ReportPage> arr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT count(*) FROM report;");
            res.beforeFirst();
            for (int i = 0; res.next(); i++) {
                info = res.getInt(1);
            }

        } catch (Exception ex) {
        }
        return info;
    }

    public int getNextReportNr() {
        int info = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT max(reportNR) FROM report;");
            res.next();
            info = res.getInt(1) + 1;
            statement.executeUpdate("ALTER TABLE report AUTO_INCREMENT = " + info + ";");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return info;
    }

    public int getNextReportPageNr() {
        int info = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT max(reportpageNR) FROM reportpage;");
            res.next();
            info = res.getInt(1) + 1;
            statement.executeUpdate("ALTER TABLE report AUTO_INCREMENT = " + info + ";");
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return info;
    }
}
