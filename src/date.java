package App;
import java.time.*;
public class date {
    private short day;
    private short month;
    private int year;
    public short getDay() {
        return day;
    }
  
    public void setDay(short day) {
        this.day = day;
    }
  
    public short getMonth() {
        return month;
    }
  
    public void setMonth(short month) {
        this.month = month;
    }
  
    public int getYear() {
        return year;
    }
  
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString()
    {
        return day+"-"+month+"-"+year;
    }
    public date() {
    }
    public date(int year, short month, short day){
        if(day > 2)
        {
            int dom = switch(month){
                case 2 -> ((year % 4)==0 ? 29 : 28 );
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
            if(day > dom) {
                if(day==29)
                    throw new DateTimeException(" dateInvalid 'February 29' as '\" + year + \"' is not a leap year");
                else
                    throw new DateTimeException("Invalid date '" + Month.of(month).name() + " " + day + "'");
            }
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public date create(int year,short month,short day)
    {
        return new date(year,month,day);
    }
  }