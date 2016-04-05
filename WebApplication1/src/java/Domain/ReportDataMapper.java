/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import helperClasses.Comment;
import helperClasses.Date;
import helperClasses.Report;
import helperClasses.ReportPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Emil
 */
public class ReportDataMapper
{

    public void addReportToDB(Report Report)
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into `report` (`BuildingID`,`Date`,`StateNR`)" + " values("
                    + Report.getBuildingID() + "',"
                    + Report.getReportDate() + "',"
                    + +Report.getState() + "');");
            for (ReportPage reportpage : Report.getReportPages())
            {
                statement.executeUpdate("insert into `reportpage`(`ReportNR`,`PreviousDamaged`,`Damagedate`,`DamagedPlace`,"
                        + "`Cause`,`Repairs`,`Moist`,`Rot`,`Mold`,`Fire`,`Other`,`MoistScan`)" + " values("
                        + Report.getReportnr() + "',"
                        + reportpage.isPreviousDamaged() + "',"
                        + reportpage.getDamagedDate() + "',"
                        + reportpage.getDamagedPlace() + "',"
                        + reportpage.getCause() + "',"
                        + reportpage.getRepairs() + "',"
                        + reportpage.isMoist() + "',"
                        + reportpage.isRot() + "',"
                        + reportpage.isMold() + "',"
                        + reportpage.isFire() + "',"
                        + reportpage.getOther() + "',"
                        + reportpage.isMoistScan() + "');");
                for (Comment comment : reportpage.getComments())
                {
                    statement.executeUpdate("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values("
                            + reportpage.getReportPageNr() + "',"
                            + comment.getType() + "',"
                            + comment.getText() + "',"
                            + ");");
                }
            }
            if (Report.getOuterWalls() != null)
            {
                statement.executeUpdate("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values("
                        + +Report.getReportnr() + "',"
                        + Report.getOuterWalls().getType() + "',"
                        + Report.getOuterWalls().getText() + "',"
                        + ");");
            }
            if (Report.getRoof() != null)
            {
                statement.executeUpdate("insert into `comments`(`ReportNR`,`ReportPageNr`,`CommentType`,`Text`) values("
                        + +Report.getReportnr() + "',"
                        + Report.getRoof().getType() + "',"
                        + Report.getRoof().getText() + "',"
                        + ");");
            }
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public Report getReportFromDB(int ReportID)
    {
        Report report = null;

//        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select  ReportPageNr ,reportNR, "
                    + "(select BuildingID from report where report.reportNR  = e.reportNR),"
                    + "(select `Date` from report where report.reportNR  = e.reportNR),"
                    + "(select StateNR from report where report.reportNR  = e.reportNR), "
                    + "PreviousDamaged, Damagedate,DamagedPlace,Cause,Repairs,Moist,Rot,"
                    + "Mold,fire,other,MoistScan from reportpage e;");
            res.beforeFirst();
            for (int i = 0; res.next(); i++)
            {
                if (res.getInt(2) == ReportID)
                {
//                    info[0] = res.getInt(2);
//                    info[1] = res.getInt(3);
//                    info[2] = res.getInt(5);
                    arr.add(new ReportPage(res.getInt(2), res.getInt(1), res.getBoolean(6), new Date(res.getDate(7)),
                            res.getString(8), res.getString(9), res.getString(10), res.getBoolean(11), res.getBoolean(12),
                            res.getBoolean(13), res.getBoolean(14), res.getString(15), res.getBoolean(16), null));
                }
            }
            report = new Report(res.getInt(2), res.getInt(3), new Date(res.getDate(4)), res.getInt(5),
                    (ReportPage[]) arr.toArray(), null, null);
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return report;
    }

    public ArrayList<Report> getReportsFromDB()
    {
        ArrayList<Report> report = new ArrayList<>();

//        int[] info = new int[3];
        ArrayList<ReportPage> arr = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select  ReportPageNr ,reportNR, "
                    + "(select BuildingID from report where report.reportNR  = e.reportNR),"
                    + "(select `Date` from report where report.reportNR  = e.reportNR),"
                    + "(select StateNR from report where report.reportNR  = e.reportNR), "
                    + "PreviousDamaged, Damagedate,DamagedPlace,Cause,Repairs,Moist,"
                    + "Rot,Mold,fire,other,MoistScan from reportpage e;");

            res.beforeFirst();

            for (int i = 0; res.next(); i++)
            {
//                info[0] = res.getInt(2);
//                info[1] = res.getInt(3);
//                info[2] = res.getInt(5);
                arr.add(new ReportPage(res.getInt(2), res.getInt(1), res.getBoolean(6), new Date(res.getDate(7)),
                        res.getString(8), res.getString(9), res.getString(10), res.getBoolean(11), res.getBoolean(12),
                        res.getBoolean(13), res.getBoolean(14), res.getString(15), res.getBoolean(16), null));
                Report reportholder = new Report(res.getInt(2), res.getInt(3), new Date(res.getDate(4)),
                        res.getInt(5), null, null, null);

                if (i == 0 || !reportholder.equals(report.get(report.size())))
                {
                    report.add(reportholder);
                }
            }
            for (Report singlereport : report)
            {
                ArrayList<ReportPage> reportpageholder = new ArrayList<>();
                for (ReportPage reportPage : arr)
                {
                    if (reportPage.getReportNr() == singlereport.getReportnr())
                    {
                        reportpageholder.add(reportPage);
                    }
                }
                singlereport.setReportPages((ReportPage[]) reportpageholder.toArray());
            }
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return report;
    }

    public int getNumbeOfReportFromDB()
    {

        int info = 0;
        ArrayList<ReportPage> arr = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Connector.URL, Connector.USERNAME, Connector.PASSWORD);
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT count(*) FROM report;");

            info = res.getInt(1);
        } catch (Exception ex)
        {
            ex.toString();
        }
        return info;
    }
}
