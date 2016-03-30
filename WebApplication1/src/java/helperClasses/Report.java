/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

/**
 *
 * @author peter L Lange
 */
public class Report
{
    int reportnr;
    int buildingID;
    Date reportDate;
    int state;
    ReportPage[] reportPages;
    Comment outerWalls;
    Comment roof;

    public Report(int reportnr, int buildingID, Date reportDate, int state, ReportPage[] reportPages, Comment outerWalls, Comment roof)
    {
        this.reportnr = reportnr;
        this.buildingID = buildingID;
        this.reportDate = reportDate;
        this.state = state;
        this.reportPages = reportPages;
        this.outerWalls = outerWalls;
        this.roof = roof;
    }

    public int getReportnr()
    {
        return reportnr;
    }

    public void setReportnr(int reportnr)
    {
        this.reportnr = reportnr;
    }

    public int getBuildingID()
    {
        return buildingID;
    }

    public void setBuildingID(int buildingID)
    {
        this.buildingID = buildingID;
    }

    public Date getReportDate()
    {
        return reportDate;
    }

    public void setReportDate(Date reportDate)
    {
        this.reportDate = reportDate;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public ReportPage[] getReportPages()
    {
        return reportPages;
    }

    public void setReportPages(ReportPage[] reportPages)
    {
        this.reportPages = reportPages;
    }

    public Comment getOuterWalls()
    {
        return outerWalls;
    }

    public void setOuterWalls(Comment outerWalls)
    {
        this.outerWalls = outerWalls;
    }

    public Comment getRoof()
    {
        return roof;
    }

    public void setRoof(Comment roof)
    {
        this.roof = roof;
    }

}
