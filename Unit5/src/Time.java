/**
 * 
 * @author Zachary McKinney
 * @version 1.0
 */

public class Time {

    // attributes
    private int seconds;
    public final int SEC_PER_HOUR = 3600;
    public final int SEC_PER_MIN = 60;
    public final int HOUR_PER_DAY = 24;
    public final int SEC_PER_DAY = 86400;

    // constructors
    public Time() {
        this.seconds = 0;
    }

    public Time(int hour, int minute, int second) {
        this.seconds = 0;
        this.setTime(hour, minute, second);
    }
    
    public Time(int totalSeconds) { 
        totalSeconds %= SEC_PER_DAY; 
        this.seconds = totalSeconds;
    } 

    // behaviors
    public int getHour() {
        return (this.seconds / SEC_PER_HOUR);
    }

    public int getMinute() {
        return (this.seconds % SEC_PER_HOUR) / SEC_PER_MIN;
    }

    public int getSecond() {
        return (this.seconds % SEC_PER_MIN);
    }

    // adding setter methods like this make the object mutable
    public void setTime(int hour, int minute, int second) {
        second += hour * SEC_PER_HOUR + SEC_PER_MIN * minute;
        this.seconds = second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d",
                this.getHour(), this.getMinute(), this.getSecond());
    }

    public Time add(Time t2) {
        return new Time(this.seconds + t2.seconds);
    }

    public Time subtract(Time t2) {
        int result = this.seconds - t2.seconds;
        if(result < 0) {
            return new Time(SEC_PER_DAY + result);
        }
        return new Time(result);
    }

    public boolean equals(Time t2) {
        return this.seconds == t2.seconds;
    }

    public int compareTo(Time t2) {
        return this.seconds - t2.seconds;
    }

}