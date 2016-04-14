package Domain;

import java.util.ArrayList;

public class ReportPage
{

    int reportNr;
    int reportPageNr;
    boolean previousDamaged;
    Date damagedDate;
    String damagedPlace;
    String cause;
    String repairs;
    boolean moist;
    boolean rot;
    boolean mold;
    boolean fire;
    String other;
    boolean moistScan;
    ArrayList<Comment> comments;

   
    public ReportPage(int reportNr,int reportPageNr, boolean previousDamaged, Date damagedDate,
            String damagedPlace, String cause, String repairs, boolean moist,
            boolean rot, boolean mold, boolean fire, String other,
            boolean moistScan, ArrayList<Comment> comments)
    {
        this.reportNr = reportNr;
        this.reportPageNr = reportPageNr;
        this.previousDamaged = previousDamaged;
        this.damagedDate = damagedDate;
        this.damagedPlace = damagedPlace;
        this.cause = cause;
        this.repairs = repairs;
        this.moist = moist;
        this.rot = rot;
        this.mold = mold;
        this.fire = fire;
        this.other = other;
        this.moistScan = moistScan;
        this.comments = comments;
    }

    public boolean comeFromSameReport(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportPage other = (ReportPage) obj;
        if (this.reportNr != other.reportNr) {
            return false;
        }
        return true;
    }

    public int getReportNr() {
        return reportNr;
    }

    public void setReportNr(int reportNr) {
        this.reportNr = reportNr;
    }
    public void addComment (Comment comment){
        comments.add(comment);
    }
     public ArrayList<Comment> getComments()
    {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments)
    {
        this.comments = comments;
    }

    public int getReportPageNr()
    {
        return reportPageNr;
    }

    public void setReportPageNr(int reportPageNr)
    {
        this.reportPageNr = reportPageNr;
    }

    public boolean isPreviousDamaged()
    {
        return previousDamaged;
    }
    public int getPreviousDamaged()
    {
        if(previousDamaged)
        return 1;
        else{
            return 0;
        }
    }

    public void setPreviousDamaged(boolean previousDamaged)
    {
        this.previousDamaged = previousDamaged;
    }

    public Date getDamagedDate()
    {
        return damagedDate;
    }

    public void setDamagedDate(Date damagedDate)
    {
        this.damagedDate = damagedDate;
    }

    public String getDamagedPlace()
    {
        return damagedPlace;
    }

    public void setDamagedPlace(String damagedPlace)
    {
        this.damagedPlace = damagedPlace;
    }

    public String getCause()
    {
        return cause;
    }

    public void setCause(String cause)
    {
        this.cause = cause;
    }

    public String getRepairs()
    {
        return repairs;
    }

    public void setRepairs(String repairs)
    {
        this.repairs = repairs;
    }

    public boolean isMoist()
    {
        return moist;
    }
    public int getMoist(){
        if(moist)
        return 1;
        else{
            return 0;
        }
    }

    public void setMoist(boolean moist)
    {
        this.moist = moist;
    }

    public boolean isRot()
    {
        return rot;
    }
    public int getRot(){
        if(rot)
        return 1;
        else{
            return 0;
        }
    }

    public void setRot(boolean rot)
    {
        this.rot = rot;
    }

    public boolean isMold()
    {
        return mold;
    }
    public int getMold(){
        if(mold)
        return 1;
        else{
            return 0;
        }
    }

    public void setMold(boolean mold)
    {
        this.mold = mold;
    }

    public boolean isFire()
    {
        return fire;
    }
    public int getFire(){
        if(fire)
        return 1;
        else{
            return 0;
        }
    }

    public void setFire(boolean fire)
    {
        this.fire = fire;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(String other)
    {
        this.other = other;
    }

    public boolean isMoistScan()
    {
        return moistScan;
    }
    public int getMoistScan(){
        if(moistScan)
        return 1;
        else{
            return 0;
        }
    }

    public void setMoistScan(boolean moistScan)
    {
        this.moistScan = moistScan;
    }

}
