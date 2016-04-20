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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportDataMapper {

    public void addReportToDB(Report Report) {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            con.setAutoCommit(false);
            PreparedStatement stat;
            int i = getNextReportNr();
            int j = getNextReportPageNr();
            stat = con.prepareStatement(("insert into `report` (`BuildingID`,`Date`,`StateNR`)  values( ?, ?, ?);"));
            stat.setInt(1, Report.getBuildingID());
            stat.setDate(2, Report.getReportDate().getDate());
            stat.setInt(3, Report.getState());
            stat.executeUpdate();
            stat = con.prepareStatement("insert into `reportpage`(`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`) values(?,?,?,?,?,?,?,?,?,?,?,?);");
            for (ReportPage reportpage : Report.getReportPages()) {
                stat.setInt(1, i);
                stat.setInt(2, reportpage.getPreviousDamaged());
                stat.setDate(3, reportpage.getDamagedDate().getDate());
                stat.setString(4, reportpage.getDamagedPlace());
                stat.setString(5, reportpage.getCause());
                stat.setString(6, reportpage.getRepairs());
                stat.setInt(7, reportpage.getMoist());
                stat.setInt(8, reportpage.getRot());
                stat.setInt(9, reportpage.getMold());
                stat.setInt(10, reportpage.getFire());
                stat.setString(11, reportpage.getOther());
                stat.setInt(12, reportpage.getMoistScan());
                stat.executeUpdate();
                stat.clearParameters();
                if(reportpage.getComments()!= null)
                    CommentDataMapper.addCommnetsToDB(reportpage.getComments(), con,i,j);
                j++;
            }
            if (Report.getOuterWalls() != null) {
                CommentDataMapper.addCommnetsToDB(Report.getOuterWalls(), con,i);
            }
            if (Report.getRoof() != null) {
                CommentDataMapper.addCommnetsToDB(Report.getRoof(), con,i);
            }
            con.commit();
            System.out.println("commit");
            con.setAutoCommit(true);
        }
        catch (SQLException e) {
            e.printStackTrace();
            try {
                System.err.print("Transaction is being rolled back");
                con.rollback();
            } catch (SQLException excep) {
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param ReportID
     * @return
     */
    public Report getReportFromDB(int ReportID) {
        Report report = null;

        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        ArrayList<Comment> comarr;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            comarr = CommentDataMapper.getCommentsFromDB();

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
                    report.setOuterWalls(comment);
                } else if (comment.getReportID() == ReportID && comment.getReportPageID() == 0 && comment.getType().equals("outerWall")) {
                    report.setRoof(comment);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return report;
    }

    /**
     * gets all of the reports from the database
     *
     * @return arraylist of reports
     */
    public ArrayList<Report> getReportsFromDB() {
        ArrayList<Report> report = new ArrayList<>();

        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        ArrayList<Comment> comarr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            comarr = CommentDataMapper.getCommentsFromDB();
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
                arr.add(new ReportPage(res.getInt(2), res.getInt(1), res.getBoolean(6), new Date(res.getDate(7)), res.getString(8), res.getString(9), res.getString(10), res.getBoolean(11), res.getBoolean(12), res.getBoolean(13), res.getBoolean(14), res.getString(15), res.getBoolean(16), new ArrayList<>()));
                Report reportholder = new Report(res.getInt(2), res.getInt(3), new Date(res.getDate(4)), res.getInt(5), null, null, null);
                if (report.isEmpty() || !reportholder.equals(report.get(report.size() - 1))) {
                    report.add(reportholder);
                }
            }
            //addeing comments to reportpage
            for (ReportPage reportpage : arr) {
                for (Comment comment : comarr) {
                    if (reportpage.getReportPageNr() == comment.getReportPageID()) {
                        reportpage.addComment(comment);
                    }
                }
            }
            //addeing reportpage to reports
            for (Report singlereport : report) {
                ArrayList<ReportPage> reportpageholder = new ArrayList<>();
                for (ReportPage reportPage : arr) {
                    if (reportPage.getReportNr() == singlereport.getReportnr()) {
                        reportpageholder.add(reportPage);
                    }
                }
                ReportPage[] reportpage = new ReportPage[reportpageholder.size()];
                singlereport.setReportPages((ReportPage[]) reportpageholder.toArray(reportpage));
            }
            //adding comments to report
            for (Report singlereport : report) {
                for (Comment comment : comarr) {
                    if (comment.getReportID() == singlereport.getReportnr() && comment.getReportPageID() == 0 && comment.getType().equals("Ceiling")) {
                        singlereport.setOuterWalls(comment);
                    } else if (comment.getReportID() == singlereport.getReportnr() && comment.getReportPageID() == 0 && comment.getType().equals("outerWall")) {
                        singlereport.setRoof(comment);
                    }
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
        System.out.println("testing");
        return report;
    }

    /**
     * get a int that is the nummber of report in the database
     *
     * @return int of reports
     */
    public int getNumberOfReportsFromDB() {

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

    /**
     * returns the next reportnr
     *
     * @return returns the next reportID
     */
    public static int getNextReportNr() {
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

    /**
     * gets the next reportpage nummber
     *
     * @return returs the next reportpagenummber
     */
    public static int getNextReportPageNr() {
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
