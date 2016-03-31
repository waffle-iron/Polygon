package helperClasses;

public class Date
{
    
int year;
    int month;
    int day;
    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(java.sql.Date date){
        this(date.getYear(), date.getMonth(), date.getDay());
    }
    

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

}
