package helperClasses;

import java.util.ArrayList;

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

    public Report(int buildingID, Date reportDate, int state, ReportPage[] reportPages, Comment outerWalls, Comment roof) {
        this.buildingID = buildingID;
        this.reportDate = reportDate;
        this.state = state;
        this.reportPages = reportPages;
        this.outerWalls = outerWalls;
        this.roof = roof;
    }
    public Report(int buildingID, Date reportDate, int state, ArrayList reportPages, Comment outerWalls, Comment roof) {
        this.buildingID = buildingID;
        this.reportDate = reportDate;
        this.state = state;
        ReportPage[] stockArr = new ReportPage[reportPages.size()];
        stockArr = (ReportPage[])reportPages.toArray(stockArr);
        this.reportPages = stockArr;
        this.outerWalls = outerWalls;
        this.roof = roof;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (this.reportnr != other.reportnr) {
            return false;
        }
        return true;
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
